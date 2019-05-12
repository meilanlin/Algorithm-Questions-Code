/*
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

Assumptions

The given array is not null, and N >= 1
Examples

A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1

https://app.laicode.io/app/problem/68
 */

public class Solution {
  public int missing(int[] array) {
    // Write your solution here
    int size = array.length;
    
    int temp = 1;
    for(int i = 2; i<= size + 1; i++){
      temp = temp ^ i;
    }
        
    for(int i = 0; i< size; i++){
      temp = temp ^ array[i];
    }
    
    return temp;
  }
}