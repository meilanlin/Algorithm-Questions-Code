/*
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

The given array is not null
Examples

{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
https://app.laicode.io/app/problem/103
 */
public class Solution {
  public int longest(int[] array) {
    //corner case
    if(array.length == 0) return 0;
    if(array.length == 1) return array[0];

    int globalMax = 0;
    int localMax = 0;
  
    for(int i = 0; i < array.length; i++){
      if(array[i] == 1){
        localMax++;
      }else{
        if(globalMax < localMax) globalMax = localMax;
        localMax = 0;
      }
    }
    // ***important
    if(globalMax == 0) globalMax = localMax;
    return globalMax;
  }
}
