import java.util.Comparator;
import java.util.PriorityQueue;
/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Assumptions
A is not null
K is >= 0 and smaller than or equal to size of A

Return
an array with size K containing the K smallest numbers in ascending order

Examples
A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}

https://app.laicode.io/app/problem/25
 */

public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    // remind: the k should <= 0 because when k == 0, the top 0 smallest element will be selected
    if(array == null || array.length == 0 || k <= 0){
      return new int[0];
    }
    int[] result = new int[k];
   // create a max heap and modify a comparator
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2){
        if (o1.equals(o2)){
          return 0;
        }
        return o1 > o2 ? -1 : 1;
      }
    });
    
    // go through the array and take k smallest items
    for(int i = 0; i< array.length; i++){
      if(i < k){
        maxHeap.offer(array[i]);
      }else if(array[i] < maxHeap.peek()){
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    // take k smallest items into the result array
    for(int i = result.length - 1; i >= 0 ; i--){
      result[i] = maxHeap.poll();
    }
    return result;
  }
}
