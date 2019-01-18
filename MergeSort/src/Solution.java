public class Solution {
	public int[] mergeSort(int[] array) {
		// *** if array only has one element, there also has no needs to sort
		if (array == null || array.length <= 1) {
			return array;
		}
		int[] helper = new int[array.length];
		sort(array, helper, 0, array.length - 1);
		return array;
	}

	public void sort(int[] array, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}

		// *** should not use (l-r)/2 + r, becuase when l=0, r=1, the result equal to 1(int),
		// which is incorrect
		// int mid = (left - right)/2 + right;
		int mid = left + (right - left) / 2;
		sort(array, helper, left, mid);
		sort(array, helper, mid + 1, right);

		combine(array, helper, left, mid, right);
	}

	public void combine(int[] array, int[] helper, int left, int mid, int right) {
		// ***there should be i<=right, not i<=mid
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}

		// compare
		int leftIndex = left;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] <= helper[rightIndex]) {
				array[left] = helper[leftIndex];
				left++;
				leftIndex++;
			} else {
				array[left] = helper[rightIndex];
				left++;
				rightIndex++;
			}
		}

		// ***why only use while(leftIndex<=mid) rather than while(rightIndex<=right)?
		// Because when all elements on left side has been sorted, the right side don't
		// need sort again since they are sorted on perivous recursive.
		while (leftIndex <= mid) {
			array[left] = helper[leftIndex];
			left++;
			leftIndex++;
		}
	}
}
