/*
Reverse a given string.

Assumptions

The given string is not null.
https://app.laicode.io/app/problem/396
 */
public class Solution {
	public String reverse(String input) {
		// corner case
		if (input == null || input.length() == 1)
			return input;
		char[] result = helper(input.toCharArray(), 0, input.length() - 1);
		return new String(result);
	}

	public char[] helper(char[] input, int i, int j) {
		if (i >= j)
			return input;
		Character temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		return helper(input, i + 1, j - 1);
	}
}
