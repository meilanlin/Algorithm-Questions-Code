/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
The merge sort algorithm should be used to solve this problem.

Examples
null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
*/
// LeetCode #148 (Sort List).
class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode mergeSort(ListNode head) {
		// Write your solution here
		if (head == null || head.next == null) {
			return head;
		}

		// split list into two
		ListNode result = split(head);
		return result;

	}

	public ListNode split(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);

		ListNode newHead = mid.next;
		mid.next = null;// 要删掉mid后的nodes，这样才能保证取得一半

		ListNode node1 = split(head);
		ListNode node2 = split(newHead);

		ListNode result = combine(node1, node2);
		return result;
	}

	public ListNode combine(ListNode node1, ListNode node2) {
		ListNode head = new ListNode(0);
		ListNode dummy = head;
		while (node1 != null && node2 != null) {
			if (node1.value <= node2.value) {
				dummy.next = node1;
				node1 = node1.next;
			} else {
				dummy.next = node2;
				node2 = node2.next;
			}
			dummy = dummy.next;
		}
		if (node1 != null) {
			dummy.next = node1;
		} else {
			dummy.next = node2;
		}
		return head.next;
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}