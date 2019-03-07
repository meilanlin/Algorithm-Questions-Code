/*
Given a linked list and an sorted array of integers as the indices in the list. 
Delete all the nodes at the indices in the original list.

Examples
1 -> 2 -> 3 -> 4 -> NULL, indices = {0, 3, 5}, after deletion the list is 2 -> 3 -> NULL.

Assumptions
the given indices array is not null and it is guaranteed to contain non-negative integers sorted in ascending order.
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
	public ListNode deleteNodes(ListNode head, int[] indices) {
		// Write your solution here
		if (head == null || indices == null || indices.length == 0) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		dummy.next = head;
		int i = 0;
		int index = 0;
		// 因为head == null的情况已经先被检测了，所以这里实际可以不需要cur.next != null
		while (cur.next.next != null && index < indices.length) {
			if (i == indices[index]) {
				cur.next = cur.next.next;
				index++;
			} else {
				cur = cur.next;
			}
			i++;
		}
		if (index < indices.length && i == indices[index]) {
			cur.next = null;
		}
		return dummy.next;
	}
}
