/*
Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.

Assumptions

The given array is not null and has length of at least 1
Examples

{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
https://app.laicode.io/app/problem/119
 */
public class Solution {
  public int[] largestAndSmallest(int[] array) {
    int left = 0;
    int right = array.length - 1;
    // first compare the left-most and right-most element
    // this procedure costs n/2 times compare
    while(left < right){
      if(array[left] > array[right]){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
      }
      left++;
      right--;
    }
    // find the smallest and the largestest
    // this procedure costs 2 * n / 2 + 1 compare
    int global_min = Integer.MAX_VALUE;
    int global_max = Integer.MIN_VALUE;
    for(int i = 0; i <= array.length/2; i++){
      if(array[i] < global_min) global_min = array[i];
    }
    for(int j = array.length/2; j < array.length; j++){
      if(array[j] > global_max) global_max = array[j];
    }

    return new int[] {global_max, global_min};
  }
}
