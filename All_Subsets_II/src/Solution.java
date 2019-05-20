/*
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
https://app.laicode.io/app/problem/63
 */
public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    // corner case
    List<String> result = new ArrayList<>();
    if(set == null) return result;
    if(set.length() == 0){
        result.add("");
        return result;
    }

    char[] input = set.toCharArray();
    Arrays.sort(input);
    StringBuilder temp = new StringBuilder("");
    helper(result, input, 0, temp);
    return result;
  }

  public void helper(List<String> result, char[] set, int index, StringBuilder temp){
      // base case
      if(index == set.length){
          result.add(temp.toString());
          return;
      }
      temp.append(set[index]);
      helper(result, set, index + 1, temp);
      temp.deleteCharAt(temp.length() - 1);
      
      while(index < set.length - 1 && set[index + 1] == set[index]){
        index++;
      }

      helper(result,set,index + 1, temp);
  }
}