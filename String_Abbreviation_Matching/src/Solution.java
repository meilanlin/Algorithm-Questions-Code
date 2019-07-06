/*
Word ¡°book¡± can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".
Examples:

pattern ¡°s11d¡± matches input ¡°sophisticated¡± since ¡°11¡± matches eleven chars ¡°ophisticate¡±.
https://app.laicode.io/app/problem/292
 */
public class Solution {
	public boolean match(String input, String pattern) {
		// corner case
		if (input == null || pattern == null)
			return false;

		boolean result = helper(input.toCharArray(), pattern.toCharArray(), 0, 0);
		return result;
	}

	public boolean helper(char[] input, char[] pattern, int i, int j) {
		// base case
		if (i == input.length && j == pattern.length)
			return true;
		if (i == input.length || j == pattern.length)
			return false;

		// case 1: letter in pattern is not digit
		if (!Character.isDigit(pattern[j])) {
			if (input[i] != pattern[j])
				return false;
			return helper(input, pattern, i + 1, j + 1);
		} else {
			// case 2: letter in pattern is digit
			int number = Character.getNumericValue(pattern[j]);
			// when you find a number on cur position, you need to check whether the next
			// position is a number, too
			while (j < pattern.length - 1 && Character.isDigit(pattern[j + 1])) {
				number = number * 10 + Character.getNumericValue(pattern[j + 1]);
				j++;
			}
			if (number > input.length - i)
				return false;
			return helper(input, pattern, i + number, j + 1);
		}
	}
}
