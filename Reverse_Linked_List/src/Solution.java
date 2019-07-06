
class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;

	}

	public ListNode reverse2(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode newHead = reverse2(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
  	}


	public ListNode reverse3(ListNode head) {
		// corner case
		if (head == null) return head;
		ListNode newHead = helper(head);
		ListNode dmy = newHead;
		return newHead;
	}

	public ListNode helper(ListNode head) {
		// base case
		if (head.next == null) return head;
		ListNode next = head.next;
		ListNode newHead = helper(next);
		next.next = head;
		// 如果没有这个，那么原始链表的第一个node不会指向null，而是依然指向第二个node，形成一个cycle
		// 没有这个的话，就要在recursion之后专门将第一个node指向null
		head.next = null;
		return newHead;
	}
}
