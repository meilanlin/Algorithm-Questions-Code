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
		// 一个是null的list也是一个palindrome
		if (head == null || head.next == null) {
			return true;
		}
		// find mid point
		ListNode mid = findMid(head);
		// reverse the last half list
		ListNode newHead = reverse(mid.next);
		mid.next = null;
		// 不能只保证head!=null
		// 当node数为奇数时，除了3个node的list，其余的list的中间位置都是靠左，只有3个node的list的中间位置是靠右
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
		// 这里是&& 不是||
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
