/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions

The given array is not null and has length of at least 1.
Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1

https://app.laicode.io/app/problem/97
 */

public class Solution {
  public int largestSum(int[] array) {
    // corner case
    if(array.length == 1) return array[0];
    
    int[] M = new int[array.length];
    // Base Case
    M[0] = array[0];
    // notice that you can not give globalMax = 0 since there may has a negative integer
    int globalMax = Integer.MIN_VALUE;
    for(int i = 1; i < array.length; i++){
        if(M[i-1] >= 0){
            M[i] = M[i-1] + array[i];
        }else{
            M[i] = array[i];
        }
        
        if(M[i] > globalMax) globalMax = M[i];
    }
    return globalMax;
  }

  // optimal: this question can be store in an integer rather than an array
  public int largestSumOptimized(int[] array) {
    // corner case
    if(array.length == 1) return array[0];

    // Base Case
    int lastMax = array[0];
    // notice that you can not give globalMax = 0 since there may has a negative integer
    int globalMax = Integer.MIN_VALUE;
    for(int i = 1; i < array.length; i++){
        if(lastMax >= 0){
            lastMax = lastMax + array[i];
        }else{
            lastMax = array[i];
        }
        
        if(lastMax > globalMax) globalMax = lastMax;
    }
    return globalMax;
  }
}
