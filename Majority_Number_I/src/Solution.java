/*
Given an integer array of length L, find the number that occurs more than 0.5 * L times.

Assumptions

The given array is not null or empty
It is guaranteed there exists such a majority number
Examples

A = {1, 2, 1, 2, 1}, return 1
https://app.laicode.io/app/problem/206
 */
public class Solution {
  public int majority(int[] array) {
    int[] stage = new int[1];
    int count = 0;
    for(int i = 0; i < array.length; i++){
      if(array[stage[0]] == array[i]){
        count++;
      }else{
        if(count == 0){
          stage[0] = i;
          count++;
        }else{
          count--;
        }
      }
    }
    return array[stage[0]];
  }
}
