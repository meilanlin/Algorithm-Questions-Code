/*
Insert a new element at a specific index in the given linked list. 
The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.

Examples:
1 -> 2 -> 3 -> null, insert 4 at index 3, --> 1 -> 2 -> 3 -> 4 -> null

1 -> 2 -> null, insert 4 at index 0, --> 4 -> 1 -> 2 -> null
 */

class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode insert(ListNode head, int index, int value) {
		// 这道题如果有检测head == null，然后return head，则会报错
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		int i = 0;
		while (head != null) {
			if (i == index) {
				ListNode insertNode = new ListNode(value);
				cur.next = insertNode;
				insertNode.next = head;
				i++;
				break;
			}
			head = head.next;
			cur = cur.next;
			i++;
		}

		// if the insert position is in the last position of list
		if (i == index) {
			ListNode insertNode = new ListNode(value);
			cur.next = insertNode;
			insertNode.next = null;
		}
		return dummy.next;

	}
}
