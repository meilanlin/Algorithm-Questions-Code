/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions
The array is not null

Examples
{1, 2, 2, 3, 3, 3} ¡ú {1, 2, 3}

https://app.laicode.io/app/problem/115
 */
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    // corner case
    if(array == null || array.length == 0) return array;
    
    int i = 0;
    int j = i + 1;
    while(i < array.length && j < array.length){
        if(array[j] != array[i]){
            i++;
            array[i] = array[j];
        }
        j++;
    }
    return Arrays.copyOf(array, i + 1);
  }
}
