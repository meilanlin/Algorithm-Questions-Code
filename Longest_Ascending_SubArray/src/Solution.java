/*
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions

The given array is not null
Examples

{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
https://app.laicode.io/app/problem/86
 */
public class Solution {
  public int longest(int[] array) {
    // corner case
    if(array.length == 0) return 0;
    if(array.length == 1) return 1;

    int length = 1;
    int globalMax = length;
    for(int i = 1; i < array.length; i++){
        if(array[i] > array[i-1]){
            length += 1;
            globalMax = Math.max(globalMax, length);
        }else{
            length = 1; // this should be 1
        }
    }
    return globalMax;
  }
}
