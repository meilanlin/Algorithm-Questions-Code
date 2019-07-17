/*
Find the length of longest common subsequence of two given strings.

Assumptions

The two given strings are not null
Examples

S = ¡°abcde¡±, T = ¡°cbabdfe¡±, the longest common subsequence of s and t is {¡®a¡¯, ¡®b¡¯, ¡®d¡¯, ¡®e¡¯}, the length is 4.
https://app.laicode.io/app/problem/177
 */
public class Solution {
	public int longest(String source, String target) {
		if (source == null || source.length() == 0 || target == null || target.length() == 0)
			return 0;
		int[][] M = new int[source.length()][target.length()];
		for (int i = 0; i < source.length(); i++) {
			for (int j = 0; j < target.length(); j++) {
				if (source.charAt(i) == target.charAt(j)) {
					if (i == 0 || j == 0)
						M[i][j] = 1;
					if (i != 0 && j != 0)
						M[i][j] = 1 + M[i - 1][j - 1];
				} else {
					if (i == 0 || j == 0)
						M[i][j] = 0;
					if (i != 0 && j != 0)
						M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
				}
			}
		}
		return M[source.length() - 1][target.length() - 1];
	}
}
