/*
Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

Examples
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases
What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.

https://app.laicode.io/app/problem/4
 */
public class Solution {
  public int[] solve(int[] array) {
    // corenr case
    if(array == null || array.length == 0 || array.length == 1) return array;

    for(int i = 0; i < array.length; i++){
      for(int j = i + 1; j < array.length; j++){
        if(array[j] < array[i]){
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
    return array;
  }
}
