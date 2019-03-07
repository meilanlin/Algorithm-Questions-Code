/*
Delete the node at the given index for the given linked list.

Examples
[1, 2, 3], delete at 1 --> [1, 3]
[1, 2, 3], delete at 4 --> [1, 2, 3]
[1, 2, 3], delete at 0 --> [2, 3]
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
	public ListNode deleteNode(ListNode head, int index) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		dummy.next = head;
		int i = 0;
		while (cur.next != null && cur.next.next != null) {
			if (i == index) {
				cur.next = cur.next.next;
				return dummy.next;
			}
			cur = cur.next;
			i++;
		}

		if (i == index) {
			cur.next = null;
		}
		return dummy.next;
	}
}
