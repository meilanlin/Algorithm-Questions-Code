/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Assumptions
Both strings are not null

Examples
string one: “sigh”, string two : “asith”

the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).

https://app.laicode.io/app/problem/100
 */
public class Solution {
	public int editDistance(String one, String two) {
		// corner case
		if (one.length() == 0)
			return two.length();
		if (two.length() == 0)
			return one.length();

		int[][] M = new int[one.length() + 1][two.length() + 1];

		for (int i = 0; i < one.length() + 1; i++) {
			for (int j = 0; j < two.length() + 1; j++) {
				if (i == 0) {
					M[i][j] = j; // base case
				} else if (j == 0) {
					M[i][j] = i; // base case
				} else { // 使用i-1的原因是 我们的i和j是从0开始到two.length()+1结束，这么做的目的是为了方便存储进M[]
						 // 又因为i,j=0表示的是字符串头假想的"", 所以对于one和two两个string，我们需要在i,j=1时来取它第一个字母
					if (one.charAt(i - 1) == two.charAt(j - 1)) {
						M[i][j] = M[i - 1][j - 1];
					} else {
						int replaceNum = M[i - 1][j - 1] + 1;
						int deleteNum = M[i - 1][j] + 1;
						int insertNum = M[i][j - 1] + 1;
						int temp = Math.min(replaceNum, deleteNum);
						M[i][j] = Math.min(temp, insertNum);
					}
				}
			}
		}
		return M[one.length()][two.length()];
	}
}
