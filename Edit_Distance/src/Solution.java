/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Assumptions
Both strings are not null

Examples
string one: ��sigh��, string two : ��asith��

the edit distance between one and two is 2 (one insert ��a�� at front then replace ��g�� with ��t��).

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
				} else { // ʹ��i-1��ԭ���� ���ǵ�i��j�Ǵ�0��ʼ��two.length()+1��������ô����Ŀ����Ϊ�˷���洢��M[]
						 // ����Ϊi,j=0��ʾ�����ַ���ͷ�����"", ���Զ���one��two����string��������Ҫ��i,j=1ʱ��ȡ����һ����ĸ
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
