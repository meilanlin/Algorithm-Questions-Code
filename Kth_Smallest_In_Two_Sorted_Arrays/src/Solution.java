/*
Given two sorted arrays of integers, find the Kth smallest number.

Assumptions

The two given arrays are not null and at least one of them is not empty

K >= 1, K <= total lengths of the two sorted arrays

Examples

A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */
public class Solution {
  public int kth(int[] a, int[] b, int k) {
    // corner case
    if(a == null || a.length == 0) return b[k - 1];
    if(b == null || b.length == 0) return a[k - 1];
    if(k == 1) return a[0] < b[0] ? a[0] : b[0];
    int result = helper(a, 0, b, 0, k);
    return result;
  }

  public int helper(int[] a, int aLeft, int[] b, int bLeft, int k){
    // base case
    if(aLeft >= a.length){
      return b[bLeft + k - 1];
    }
    if(bLeft >= b.length){
      return a[aLeft + k - 1];
    }
    if(k == 1) return a[aLeft] < b[bLeft] ? a[aLeft] : b[bLeft];

    int aMid = aLeft + k/2 - 1; // the k-th point of the valid array
    int bMid = bLeft + k/2 - 1; // the k-th point of the valid array
    int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
    int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];

    if(aVal < bVal){
      return helper(a, aMid + 1, b, bLeft, k - k/2);
    }else{
      return helper(a, aLeft, b, bMid + 1, k - k/2);
    }

  }
}
