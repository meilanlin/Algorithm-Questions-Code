/*
Determine if a given integer is power of 2.

Examples

16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not
https://app.laicode.io/app/problem/74
 */
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here
    int result = number & (number - 1);
    if(result == 0 && number > 0)return true;
    return false;
  }
}