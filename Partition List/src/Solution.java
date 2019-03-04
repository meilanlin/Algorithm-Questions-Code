// LeetCode #86 (Partition List).

class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode partition(ListNode head, int target) {
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode dummySmall = head1;
		ListNode dummyLarge = head2;
		while (head != null) {
			if (head.value < target) {
				dummySmall.next = head;
				dummySmall = dummySmall.next;
			} else {
				dummyLarge.next = head;
				dummyLarge = dummyLarge.next;
			}
			head = head.next;
		}
		dummySmall.next = head2.next;
		// Important!
		dummyLarge.next = null;
		return head1.next;
	}
}