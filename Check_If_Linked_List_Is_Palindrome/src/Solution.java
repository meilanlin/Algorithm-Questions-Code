/*
Given a linked list, check whether it is a palindrome.

Examples:
Input:  1 -> 2 -> 3 -> 2 -> 1 -> null  	output: true.

Input:  1 -> 2 -> 3 -> null  			output: false.

Requirements: Space complexity must be O(1)

Leetcode 234
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
	public boolean isPalindrome(ListNode head) {
		// һ����null��listҲ��һ��palindrome
		if (head == null || head.next == null) {
			return true;
		}
		// find mid point
		ListNode mid = findMid(head);
		// reverse the last half list
		ListNode newHead = reverse(mid.next);
		mid.next = null;
		// ����ֻ��֤head!=null
		// ��node��Ϊ����ʱ������3��node��list�������list���м�λ�ö��ǿ���ֻ��3��node��list���м�λ���ǿ���
		while (head != null && newHead != null) {
			if (head.value == newHead.value) {
				head = head.next;
				newHead = newHead.next;
			} else {
				return false;
			}
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next = head;
		while (next != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		// ������&& ����||
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
