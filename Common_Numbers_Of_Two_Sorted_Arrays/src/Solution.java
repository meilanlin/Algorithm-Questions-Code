/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

Assumptions

In each of the two sorted arrays, there could be duplicate numbers.
Both two arrays are not null.
Examples

A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
https://app.laicode.io/app/problem/72
 */

public class Solution {
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		// Write your solution here
		// corner case
		if (A == null || A.size() == 0)
			return A;
		if (B == null || B.size() == 0)
			return B;

		int i = 0;
		int j = 0;
		List<Integer> result = new ArrayList<>();

		while (i < A.size() && j < B.size()) {
			int aNum = A.get(i);
			int bNum = B.get(j);

			if (aNum == bNum) {
				result.add(aNum);
				i++;
				j++;
			} else if (aNum < bNum) {
				i++;
			} else if (aNum > bNum) {
				j++;
			}
		}

		return result;

	}
}
