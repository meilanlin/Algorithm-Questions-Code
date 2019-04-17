/*
Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array does not need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
https://app.laicode.io/app/problem/258
 */

public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    int count = 0;
    for(int i = 0; i< array.length; i++){
      if(array[i] != 0){
        array[count] = array[i];
        count++;
      }
    }
    
    int zeroCount = array.length - count;
    for(int i = count; i < array.length; i++){
      array[i] = 0;
    }
    return array;
  }
}

