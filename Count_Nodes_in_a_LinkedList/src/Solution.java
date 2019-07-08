/*
Given a linked list, count the number of nodes in it.
Assumption: The linkedlist is not null or empty.

Example:

Given: 1->7->5->4->2->null
Answer: 5
https://app.laicode.io/app/problem/555
 */
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public int count(ListNode head) {
    int count = 0;
    while(head != null){
      head = head.next;
      count++;
    }
    return count;
  }
}
