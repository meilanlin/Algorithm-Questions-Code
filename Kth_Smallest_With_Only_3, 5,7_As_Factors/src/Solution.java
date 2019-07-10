/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

Assumptions

K >= 1
Examples

the smallest is 3 * 5 * 7 = 105
the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
the 5th smallest is 3 ^ 3 * 5 * 7 = 945
https://app.laicode.io/app/problem/193
 */
public class Solution {
  public long kth(int k) {
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();

    // initial state: s = 3^1 + 5^1 + 7^1
    minHeap.offer((long)3*5*7);
    // use set to deduplicate
    set.add((long)3*5*7);

    for(int i = 1; i < k; i++){
      // poll a element everytime, then we can extend with the next element
      long num = minHeap.poll();
      if(!set.contains(num * 3)){
        minHeap.offer(num * 3);
        set.add(num * 3);
      }
      if(!set.contains(num * 5)){
        minHeap.offer(num * 5);
        set.add(num * 5);
      }
      if(!set.contains(num * 7)){
        minHeap.offer(num * 7);
        set.add(num * 7);
      }
    }

    return minHeap.peek();
  }
}
