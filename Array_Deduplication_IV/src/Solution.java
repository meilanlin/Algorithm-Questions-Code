/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} �� {1, 2, 2, 2} �� {1}, return {1}
https://app.laicode.io/app/problem/118
 */
public class Solution {
	public int[] dedup(int[] array) {
		// corner case
		if (array == null || array.length == 0 || array.length == 1)
			return array;
		int slow = -1;
		int fast = 0;
		while (fast < array.length) {
			// ��ջ��Ԫ�رȽϣ��������ȣ���ѹ��ջ��
			if (slow == -1 || array[slow] != array[fast]) {
				array[++slow] = array[fast];
				fast++;
			} else {
				// �����ȣ����ҵ���һ������ȵ�Ԫ�أ�������ǰ���Ԫ��pop��
				while (fast < array.length - 1 && array[slow] == array[fast + 1]) {
					fast++;
				}
				fast++;
				slow--; // pop������Ԫ��
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}
}
