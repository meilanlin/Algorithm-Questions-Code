public class Solution {
	public int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int right = array.length - 1;
		sort(array, 0, right);
		return array;
	}

	public void sort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		// get pivot -- select from the median
		int pivotIndex = (left - right) / 2 + right;
		// swap the pivot to the last position of array
		swap(array, pivotIndex, right);

		// resort the list, /the small element must in the left side and the big element must in the right side
		int pivotPosition = partition(array, left, right);
		
		// divide and contour
		sort(array, 0, pivotPosition - 1);
		sort(array, pivotPosition + 1, right);
	}

	public Integer partition(int[] array, int left, int right) {
		int pivot = array[right];
		// set two pointers, i for left side, j for right side
		int i = left;
		int j = right - 1;// ***after swap the pivot, the right bound must minus 1
		// the small element must in the left side and the big element must in the right side
		while (i <= j) {
			if (array[i] < pivot) {
				i++;
			} else if (array[j] > pivot) {
				j--;
			} else {
				swap(array, i, j);
				// ***must. If don't have i++ and j--, every swap in every recursive will has two more steps.
				i++;
				j--;
			}
		}
		// swap the pivot element back to the position it should be
		// ***wrong code: swap(array, i, pivot). Ans: The pivot has been swapped
		swap(array, i, right);
		return i;
	}

	public void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
