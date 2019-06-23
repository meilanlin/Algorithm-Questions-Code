/*
Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. Return the largest number and 2nd largest number.

Assumptions

The given array is not null and has length of at least 2
Examples

{2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
https://app.laicode.io/app/problem/120
 */
public class Solution {
	class ele {
		int value;
		List<Integer> compared;

		ele(int value) {
			this.value = value;
			this.compared = new ArrayList<>();
		}
	}

	public int[] largestAndSecond(int[] array) {
		// initial element
		ele[] elements = initialElements(array);
		// compare and find the largest value
		int length = array.length;

		while (length != 1) {
			findLargest(elements, length);
			length = (length + 1) / 2;
		}
		int firstMax = elements[0].value;

		// find the second largest value
		List<Integer> compared_list = elements[0].compared;
		int secondMax = Integer.MIN_VALUE;
		for (int val : compared_list) {
			if (val > secondMax)
				secondMax = val;
		}

		return new int[] { firstMax, secondMax };
	}

	public void findLargest(ele[] elements, int length) {
		int left = 0;
		int right = length - 1;
		while (left < right) {
			if (elements[left].value < elements[right].value) {
				elements[right].compared.add(elements[left].value);
				elements[left] = elements[right];
			} else {
				elements[left].compared.add(elements[right].value);
			}
			left++;
			right--;
		}
	}

	public ele[] initialElements(int[] array) {
		ele[] elements = new ele[array.length];
		for (int i = 0; i < array.length; i++) {
			elements[i] = new ele(array[i]);
		}
		return elements;
	}
}
