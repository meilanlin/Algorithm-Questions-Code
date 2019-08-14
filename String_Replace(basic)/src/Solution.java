/*
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions
input, S and T are not null, S is not empty string

Examples
input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "laicode", S = "code", T = "offer", input becomes "laioffer"
 https://app.laicode.io/app/problem/649
 */
public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
		char[] array = input.toCharArray();
		int start = 0;
		int end = source.length() - 1;

		while (start < array.length && end < array.length) {
			String segement = new String(array, start, source.length());
			if (segement.equals(source)) {
				StringBuilder sb = new StringBuilder();
				sb.append(input, 0, start);
				sb.append(target);
				
				if (end != array.length - 1) {
					sb.append(input, end + 1, array.length);
				}
				input = sb.toString();
				array = input.toCharArray();
				start = start + target.length();
				end = start + source.length() - 1;
			} else {
				start++;
				end++;
			}
		}
		return input;
  }
}
