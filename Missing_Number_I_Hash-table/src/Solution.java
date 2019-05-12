import java.util.HashSet;
import java.util.Set;

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
    // corner case
    if(array.length == 1) return 1;
    
    Set<Integer> set = new HashSet<>();
    for(int num : array){
      set.add(num);
    }
    
    int result = 0;
    for(int i = 1; i <= array.length + 1; i++){
      if(!set.contains(i)) result = i;
    }
    
    return result; 
  }
}
