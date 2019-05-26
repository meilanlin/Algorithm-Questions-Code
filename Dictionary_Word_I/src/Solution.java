/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
https://app.laicode.io/app/problem/99
 */
public class Solution {
  public boolean canBreak(String input, String[] dict) {
    boolean[] M = new boolean[input.length()+1];
    // M储存的是每个substring是否在dict中存在
    // 每次大循环代表我们把substring看成一个input，来判断是否存在
    for(int i = 1; i <= input.length(); i++){
        String subString = input.substring(0, i);
        
        if(checkExist(subString,dict)){
            M[i] = true; 
        }else{
            // 每次小循环的意思是借用之前的结果来判断当前的string的结果
            for(int j = 1; j < i; j++){
                String rightString = input.substring(j, i);
                if(M[j]&&checkExist(rightString, dict)){
                    M[i] = true;
                }
            }
        }
    }
    return M[input.length()];
  }

  public boolean checkExist(String string, String[] dict){
      for(String ele : dict){
          if(ele.equals(string)) return true;
      }
      return false;
  }
}
