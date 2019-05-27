/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine if you are able to reach the last index.

Assumptions

The given array is not null and has length of at least 1.
Examples

{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

{2, 1, 1, 0, 2}, we are not able to reach the end of array
https://app.laicode.io/app/problem/88
 */
public class Solution {
  public boolean canJump(int[] array) {
    // corner case
    if(array.length == 1) return true;
    // M[] represents wheather the current element can jump to the target element
    boolean[] M = new boolean[array.length];
    // base case
    M[array.length - 1] = true;
    int target = array.length - 1;
    for(int i = array.length - 2; i>=0; i--){
        int number = array[i];
        if(number >= target - i){
            M[i] = true;
            target = i;
        }else{
            M[i] = false;
        }
    }
    return M[0];
  }
}
