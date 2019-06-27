/*
Given two sorted arrays, merge them into one sorted array.

Assumption: the two arrays are not null or empty.

Example:
array1 = {3,7}
array2 = {1,6,8,9}
answer = {1,3,6,7,8,9}

https://app.laicode.io/app/problem/547
 */
public class Solution {
  public int[] merge(int[] one, int[] two) {
    // Write your solution here
    int[] result = new int[one.length + two.length];
    int i = 0;
    int j = 0;
    while(i < one.length && j < two.length){
      if(one[i] < two[j]){
        result[i+j] = one[i];
        i++;
      }else{
        result[i+j] = two[j];
        j++;
      }
    }
    
    while(i < one.length) result[i+j] = one[i++];
    while(j < two.length) result[i+j] = two[j++];

    return result;
  }
}
