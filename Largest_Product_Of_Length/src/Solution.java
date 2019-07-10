/*
Given a dictionary containing many words, find the largest product of two words¡¯ lengths, such that the two words do not share any common characters.

Assumptions

The words only contains characters of 'a' to 'z'
The dictionary is not null and does not contains null string, and has at least two strings
If there is no such pair of words, just return 0
Examples

dictionary = [¡°abcde¡±, ¡°abcd¡±, ¡°ade¡±, ¡°xy¡±], the largest product is 5 * 2 = 10 (by choosing ¡°abcde¡± and ¡°xy¡±)
https://app.laicode.io/app/problem/191
 */
public class Solution {
  public int largestProduct(String[] dict) {
    // sort it in a maxHeap
    Arrays.sort(dict, new Comparator<String>(){
      @Override
      public int compare(String s1, String s2){
        if(s1.length() < s2.length()) return 0;
        return s1.length() > s2.length() ? -1 : 1;
      }
    });

    // always use the first largest string and the second largest string to get the product of two
    for(int i = 0; i < dict.length; i++){
      for(int j = i + 1; j < dict.length; j++){
        // check whether two strings have common character
        if(noCommonCharacters(dict[i], dict[j])){
          return dict[i].length() * dict[j].length();
        }
      }
    }

    return 0;
  }

  public boolean noCommonCharacters(String a, String b){
    Set<Character> set = new HashSet<>();
    for(char letter : a.toCharArray()){
      set.add(letter);
    }
    for(char letter : b.toCharArray()){
      if(set.contains(letter)) return false;
    }

    return true;
  }
}
