/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum and the indices of the left and right boundaries of the subarray. If there are multiple solutions, return the leftmost subarray.

Assumptions

The given array is not null and has length of at least 1.
Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5. The indices of the left and right boundaries are 0 and 2, respectively.

{-2, -1, -3}, the largest subarray sum is -1. The indices of the left and right boundaries are both 1


Return the result in a array as [sum, left, right]
https://app.laicode.io/app/problem/489
 */
public class Solution {
  public int[] largestSum(int[] array) {
    int[] result = new int[3];
    // corner case
    if(array.length == 1){
        result[0] = array[0];
        return result;
    } 
    // base case
    int lastMax = array[0]; 
    int globalMax = Integer.MIN_VALUE;
    int left = 0;
    int right = 0;
    int globalLeft = 0;
    int globalRight = 0;

    for(int i = 1; i < array.length; i++){
        if(lastMax >= 0){
            lastMax = lastMax + array[i];
            right++;
        }else{
            lastMax = array[i];
            left = i;
            right = i;
        }
        
        if(lastMax > globalMax){
            globalMax = lastMax;
            globalLeft = left;
            globalRight = right;
        }
    }
    
    result[0] = globalMax;
    result[1] = globalLeft;
    result[2] = globalRight;
    return result;
  }
}
