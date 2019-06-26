/*
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. 
Make a deep copy of the original list.

https://app.laicode.io/app/problem/131
 */


/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // corner case
    if(head == null) return null;

    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newHead = new RandomListNode(head.value);
    map.put(head, newHead);
    RandomListNode cur = newHead;

    while(head != null){
      if(head.next != null){
        if(!map.containsKey(head.next)){
          RandomListNode newNext = new RandomListNode(head.next.value);
          map.put(head.next, newNext);
        }
        cur.next = map.get(head.next);
      }

      if(head.random != null){
        if(!map.containsKey(head.random)){
          RandomListNode newRandom = new RandomListNode(head.random.value);
          map.put(head.random, newRandom);
        }
        cur.random = map.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }

    return newHead;
  }
}