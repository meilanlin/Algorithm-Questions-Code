/*
Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

Assumptions

A is not null
Examples
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because [2, 3, 4, 5] is the longest ascending subsequence.
https://app.laicode.io/app/problem/1
 */
public class Solution {
  public int longest(int[] array) {
    if(array.length == 0) return 0;
    if(array.length == 1) return 1;

    int[] M = new int[array.length];
    M[0] = 1;
    int globalMax = 0;
    for(int i = 1; i < array.length; i++){
      int max = 1;
      for(int j = 0; j < i; j++){
        if(array[j] < array[i]){
          max = Math.max(max, M[j] + 1);
        }
      }
      M[i] = max;
      globalMax = Math.max(M[i], globalMax);
    }
    return globalMax;
  }
}
