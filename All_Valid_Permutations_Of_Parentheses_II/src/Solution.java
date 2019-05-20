/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
https://app.laicode.io/app/problem/179
 */
public class Solution {
	private static final char[] PS = new char[] { '(', ')', '<', '>', '{', '}' };

	public List<String> validParentheses(int l, int m, int n) {
		// Write your solution here
		// no corner case
		Stack<Integer> stack = new Stack<Integer>();
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder("");
		int[] parenNum = { l, l, m, m, n, n };
		int total_len = 2 * (l + m + n);
		helper(total_len, parenNum, sb, stack, result);
		return result;
	}

	public void helper(int total_len, int[] parenNum, StringBuilder sb, Stack<Integer> stack, List<String> result) {
		// base case
		if (sb.length() == total_len) {
			result.add(sb.toString());
			return;
		}

		for (int i = 0; i < parenNum.length / 2; i++) {
			// add left parenthese
			int index = 2 * i;
			if (parenNum[index] > 0) {
				char left = PS[index];
				sb.append(left);
				stack.push(index);
				parenNum[index]--;

				helper(total_len, parenNum, sb, stack, result);

				sb.deleteCharAt(sb.length() - 1);
				parenNum[index]++;
				stack.pop();
			}

			// add right parenthese
			if (!stack.isEmpty() && stack.peek().equals(index)) {
				index = stack.pop();
				int newIndex = index + 1;
				char right = PS[newIndex];
				sb.append(right);

				helper(total_len, parenNum, sb, stack, result);

				sb.deleteCharAt(sb.length() - 1);
				stack.push(index);
			}
		}
	}
}
