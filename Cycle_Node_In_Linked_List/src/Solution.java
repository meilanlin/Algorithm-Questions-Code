/*
Check if a given linked list has a cycle. 

Return the node where the cycle starts. Return null if there is no cycle.
*/
// leetcode 142
class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode cycleNode(ListNode head) {
		// 这里不检测head也可以，因为下面的while会将它检测
		if (head == null) {
			return head;
		}
		// write your solution here
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
// Time O(n) Space O(1)