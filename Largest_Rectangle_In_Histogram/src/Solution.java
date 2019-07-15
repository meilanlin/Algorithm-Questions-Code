/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

Assumptions
The given array is not null or empty

Examples
{ 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)

https://app.laicode.io/app/problem/198
 */
public class Solution {
	public int largest(int[] array) {
		// coner case
		if (array.length == 1)
			return array[0];

		Stack<Integer> stack = new Stack<>();
		int globalMax = 0;
		int cur = 0;
		for (int i = 0; i <= array.length; i++) {
			if (i != array.length) {
				cur = array[i];
			} else {
				// insert a dummy node at the end of the column
				cur = 0;
			}

			while (!stack.isEmpty() && cur <= array[stack.peek()]) {
				int height = array[stack.pop()];
				// find the position where start to increase
				int left = stack.isEmpty() ? 0 : stack.peek() + 1;

				int area = height * (i - left);
				globalMax = Math.max(area, globalMax);
			}
			stack.push(i);
		}
		return globalMax;
	}
}
