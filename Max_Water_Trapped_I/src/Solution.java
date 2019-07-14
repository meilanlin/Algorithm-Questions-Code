/*
Given a non-negative integer array representing the heights of a list of adjacent bars. 
Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions
The given array is not null

Examples
{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 
(at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
https://app.laicode.io/app/problem/199
 */
public class Solution {
  public int maxTrapped(int[] array) {
    // corner case
    if(array == null || array.length <=1) return 0;

    int[] m1 = new int[array.length];
    int[] m2 = new int[array.length];
    int left = 0;
    int right = array[array.length - 1];

    for(int i = 0; i < array.length; i++){
      int j = array.length - i - 1;
      if(array[i] <= left){
        m1[i] = left;
      }else if(array[i] > left){
        m1[i] = array[i];
        left = array[i];
      }

      if(array[j] <= right){
        m2[j] = right;
      }else{
        m2[j] = array[j];
        right = array[j];
      }
    }

    int water = 0;
    for(int i = 0; i < array.length; i++){
      int line = Math.min(m1[i], m2[i]);
      water += line - array[i];
    }
    return water;
  }
}
