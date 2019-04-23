/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
https://app.laicode.io/app/problem/62
 */
public class Solution {
  public List<String> subSets(String set) {
    //corner case
    List<String> result = new ArrayList<>();
    if(set == null) return result;
    if(set.length() == 0){
      result.add("");
      return result;
    }
    
    StringBuilder tempString = new StringBuilder("");
    int index = 0;
    char[] charSet = set.toCharArray();
    findSets(charSet, result, index, tempString);
    return result;
  }
  
  public void findSets( char[] set, List<String> result, int index, StringBuilder tempString){
    // base case
   if (index == set.length) {
			result.add(tempString.toString());
			return;
		}

		tempString.append(set[index]);
		findSets(set, result, index + 1, tempString);
		tempString.deleteCharAt(tempString.length() - 1);
		findSets(set, result, index + 1, tempString);
  }
}
