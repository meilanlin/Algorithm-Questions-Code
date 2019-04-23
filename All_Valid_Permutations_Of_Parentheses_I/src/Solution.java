import java.util.ArrayList;
import java.util.List;
/*
Given N pairs of parentheses ¡°()¡±, return a list with all the valid permutations.

Assumptions

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
https://app.laicode.io/app/problem/66
 */
public class Solution {
	  public List<String> validParentheses(int n) {
	    // Write your solution here
	    List<String> result = new ArrayList<String>();
	    if(n == 1){
	      result.add("()");
	      return result;
	    }
	    int left = 0;
	    int right = 0;
	    StringBuilder temp = new StringBuilder();
	    findPar(result,temp,left,right, n);
	    return result;
	  }
	  
	  public void findPar(List<String> list, StringBuilder temp, int left, int right, int n){
	    // base case
	    if(left + right == 2 * n){
	      list.add(temp.toString());
	      return;
	    }
	    
	    if(left < n ){
	      temp.append("(");
	      findPar(list, temp, left + 1, right, n);
	      temp.deleteCharAt(temp.length() - 1);
	    }
	    
	    if(left > right ){
	      temp.append(")");
	      findPar(list, temp, left, right + 1, n);
	      temp.deleteCharAt(temp.length() - 1);
	    }
	  }
	}
