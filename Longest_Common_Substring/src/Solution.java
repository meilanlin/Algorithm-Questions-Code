/*
Find the longest common substring of two given strings.

Assumptions

The two given strings are not null
Examples

S = ¡°abcde¡±, T = ¡°cdf¡±, the longest common substring of S and T is ¡°cd¡±
https://app.laicode.io/app/problem/176
 */
public class Solution {
	public String longestCommon(String source, String target) {
		int[][] M = new int[source.length()][target.length()];
		int maxLength = 0;
		int subStringStart = 0;
		for (int i = 0; i < source.length(); i++) {
			for (int j = 0; j < target.length(); j++) {
				if (source.charAt(i) == target.charAt(j)) {
					if (i == 0 || j == 0)
						M[i][j] = 1;
					if (i != 0 && j != 0)
						M[i][j] = 1 + M[i - 1][j - 1];
				} else {
					M[i][j] = 0;
				}
				if (M[i][j] > maxLength) {
					maxLength = M[i][j];
					subStringStart = i - maxLength + 1;
				}
			}
		}
		String result = source.substring(subStringStart, subStringStart + maxLength);
		return result;
	}
}
