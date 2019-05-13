/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions

The given input string is not null.
The characters to be removed is given by another string, it is guaranteed to be not null.
Examples

input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
https://app.laicode.io/app/problem/395
 */

public class Solution {
  public String remove(String input, String t) {
    // corner case
    if(t == null || t == ""||input == null || input.length() == 0) return input;
    
    int i = 0;
    int j = 0;
    StringBuilder str = new StringBuilder(input);
    
    while(j < input.length()){
      char cur = str.charAt(j);
      if(!delete(cur, t)){
        str.setCharAt(i, str.charAt(j));
        i++;
        j++;
      }else{
        j++;
      }
    }
    String result = str.delete(i, input.length()).toString();
    return result;
  }
  
  public boolean delete(char cur, String t){
    for(int i = 0; i < t.length(); i++){
      if(cur == t.charAt(i)) return true;
    }
    return false;
  }
}
