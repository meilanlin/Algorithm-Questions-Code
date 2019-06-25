/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4
Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false

https://app.laicode.io/app/problem/188
 */
public class Solution {
	public boolean exist(int[] array, int target) {
		// sort first
		Arrays.sort(array);
		// since the array has sorted, we create 4 numbers and give them physics meaning
		// we assume the 4 numbers first and there index i_1 < j_1 < i_2 < j_2
		Map<Integer, Integer> map = new HashMap<>();
		// enumerate first 2 numbers i1 and j1
		for (int j_1 = 1; j_1 < array.length - 2; j_1++) {
			for (int i_1 = 0; i_1 < j_1; i_1++) {
				int firstTwoSums = array[j_1] + array[i_1];
				// if contains, means there already has a j_1 which is smaller than current one
				if (!map.containsKey(firstTwoSums)) {
					map.put(firstTwoSums, j_1);
				}
			}
		}

		// enumerate last 2 numbers i2 and j2
		for (int i_2 = 2; i_2 < array.length - 1; i_2++) {
			for (int j_2 = i_2 + 1; j_2 < array.length; j_2++) {
				int lastTwoSums = array[i_2] + array[j_2];
				if (map.containsKey(target - lastTwoSums) && map.get(target - lastTwoSums) < i_2) {
					return true;
				}
			}
		}
		return false;
	}
}
