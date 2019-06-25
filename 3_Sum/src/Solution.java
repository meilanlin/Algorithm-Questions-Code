/*
Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

The given array is not null and has length of at least 3
No duplicate triples should be returned, order of the values in the tuple does not matter
Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
https://app.laicode.io/app/problem/186
 */
public class Solution {
	public List<List<Integer>> allTriples(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			// 避免重复
			if (i > 0 && array[i] == array[i - 1])
				continue;
			findCombination(i, array, result, target - array[i]);
		}
		return result;
	}

	public void findCombination(int cur, int[] array, List<List<Integer>> result, int target) {
		int i = cur + 1;
		int j = array.length - 1;

		while (j > i) { // j不能等于 i
			int left = array[i];
			int right = array[j];
			if (left + right > target) {
				j--;
			} else if (left + right < target) {
				i++;
			} else {
				// 避免重复
				if (i - cur == 1)
					result.add(Arrays.asList(left, right, array[cur]));
				if (i - cur > 1 && array[i] != array[i - 1]) {
					result.add(Arrays.asList(left, right, array[cur]));
				}
				i++;
				j--;
			}
		}
	}
}
