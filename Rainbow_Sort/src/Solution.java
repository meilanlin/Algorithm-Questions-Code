/*
Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

Examples

{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
Assumptions

The input array is not null.
Corner Cases

What if the input array is of length zero? In this case, we should not do anything as well.
https://app.laicode.io/app/problem/11
 */
public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    if(array == null || array.length == 0){
      return array;
    }
    
    int redCount = 0;
    int greenCount = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] == -1){
        array[redCount] = array[i];
        redCount ++;
      }else if(array[i] == 0){
        greenCount ++;
      }
    }
    
    while(greenCount != 0){
      array[redCount++] = 0;
      greenCount--;
    }
    
    for(int i = redCount; i<array.length; i++){
      array[i] = 1;
    }
    
    return array;
  }
}
