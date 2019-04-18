/*
Determine if the characters of a given string are all unique.

Assumptions
The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
The given string is not null.

Examples
the characters used in "abcd" are unique
the characters used in "aba" are not unique
https://app.laicode.io/app/problem/76
 */

public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here
    int occurredChars = 0;
    for(int i = 0; i<word.length(); i++){
      char cur = word.charAt(i);
      int k = cur - 'a';
      if((occurredChars >> k & 1) == 1) return false;
      occurredChars = occurredChars | (1<<k);
    }
    return true;
  }
}
