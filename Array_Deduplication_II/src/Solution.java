/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} ¡ú {1, 2, 2, 3, 3}
https://app.laicode.io/app/problem/116
 */
public class Solution {
  public int[] dedup(int[] array) {
    // corner case
    if(array == null || array.length == 0) return array;
    if(array.length <= 2) return array;

    int s = 2;
    int f = 2;
    while(f < array.length){
      if(array[f] != array[s-2]) array[s++] = array[f];
      f++;
    }
    return Arrays.copyOf(array, s);
  }
}
