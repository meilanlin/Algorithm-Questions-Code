/*
Given a string with no duplicate characters, return a list with all permutations of the characters.

Examples

Set = ¡°abc¡±, all permutations are [¡°abc¡±, ¡°acb¡±, ¡°bac¡±, ¡°bca¡±, ¡°cab¡±, ¡°cba¡±]
Set = "", all permutations are [""]
Set = null, all permutations are []

https://app.laicode.io/app/problem/64
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	  public List<String> permutations(String set) {
	    // Write your solution here
	    // corner case
	    List<String> result = new ArrayList<String>();
	    if(set == null) return result;
	    if(set.length() == 0){
	      result.add("");
	      return result;
	    }
	    
	    char[] input = set.toCharArray();
	    int index = 0;
	    findPer(input, index, result);
	    return result;
	  }
	  
	  public void findPer(char[] input, int index, List<String> result){
	    // base case
	    if(index == input.length - 1){
	      result.add(new String(input));
	      return;
	    }
	    
	    for(int i = index; i < input.length; i++){
	      swap(input, i, index);
	      findPer(input, index + 1, result);
	      swap(input, index, i);
	    }
	  }
	  
	  public void swap(char[] input, int a, int b){
	    char temp = input[a];
	    input[a] = input[b];
	    input[b] = temp;
	  }
	}
