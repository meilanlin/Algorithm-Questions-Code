/*
Determine the number of bits that are different for two given integers.

Examples
5(��0101��) and 8(��1000��) has 3 different bits
https://app.laicode.io/app/problem/75
 */
public class Solution {
	  public int diffBits(int a, int b) {
		    // Write your solution here
		    int c = a ^ b;
		    int count = 0;
		    while(c != 0){
		      int result = c & 1;
		      // ע��increment����Ҫ��>>>, ������>>����a^bΪ����ʱ����λΪ1����>>��һֱ����ಹ1������ѭ��    
		      c = c>>>1;
		      if(result == 1) count++;
		    }
		    return count;
		  }
}
