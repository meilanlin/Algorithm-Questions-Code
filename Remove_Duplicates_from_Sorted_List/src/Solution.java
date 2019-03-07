/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Input: 1->1->2  Output: 1->2
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
	public ListNode removeDup(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode next = head.next;
		while (next != null) {
			if (cur.value == next.value) {
				next = next.next;
			} else {
				cur.next = next;
				next = next.next;
				cur = cur.next;
			}
		}
		cur.next = next;
		return dummy.next;
	}
}
// Time O(n) Space O(1)