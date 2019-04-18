/*
Determine the number of bits that are different for two given integers.

Examples
5(“0101”) and 8(“1000”) has 3 different bits
https://app.laicode.io/app/problem/75
 */
public class Solution {
	  public int diffBits(int a, int b) {
		    // Write your solution here
		    int c = a ^ b;
		    int count = 0;
		    while(c != 0){
		      int result = c & 1;
		      // 注意increment条件要用>>>, 而不是>>，当a^b为负数时，首位为1，用>>会一直在左侧补1导致死循环    
		      c = c>>>1;
		      if(result == 1) count++;
		    }
		    return count;
		  }
}
