/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} ¡ú {1}
https://app.laicode.io/app/problem/117
*/

public class Solution {
  public int[] dedup(int[] array) {
    if(array == null || array.length == 0) return array;

    int s = 0;
    int f = 0;
    while(f < array.length){
      int begin = f;
      // find and skip the duplicate number
      while(f < array.length && array[f] == array[begin]) f++;
      // transmit the non-duplicate number to the position
      if(f - begin == 1){
        array[s] = array[begin];
        s++;
      }
    }
    return Arrays.copyOf(array, s);
  }
}
