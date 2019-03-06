/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

leetcode 203
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
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.value == val) {
				cur.next = cur.next.next;// �����ɺ�cur���ڵ�ǰλ�ã���������һ��ѭ���оͿ��Լ�������ѭ�������ϵ�cur.next.next
			} else {
				cur = cur.next;
			}
		}
		// loop������cur.next��δ��⣬cur�Ѽ�����
		if (cur.next.value == val) {
			cur.next = null;
		}
		return dummy.next;
	}
}