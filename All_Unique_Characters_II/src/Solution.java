/*
Determine if the characters of a given string are all unique.

Assumptions

We are using ASCII charset, the value of valid characters are from 0 to 255
The given string is not null
Examples

all the characters in "abA+\8" are unique
"abA+\a88" contains duplicate characters
https://app.laicode.io/app/problem/77
 */
public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here
    int[] vector = {0,0,0,0,0,0,0,0};
    for(int i = 0; i<word.length(); i++){
      char cur = word.charAt(i);
      int row = cur / 32;
      int col = cur % 32;
      if((vector[row] >> col & 1) == 1) return false;
      vector[row] = vector[row] | 1<<col;
    }
    return true;
  }
}
