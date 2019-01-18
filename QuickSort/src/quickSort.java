public class quickSort {
	
	public int[] sort(int[] array) {
		// Write your solution here
		if(array==null||array.length < 2) {
			return array;
		}
		
		int length = array.length;
		if(length > 2) {
			quickSort_recursive(array, 0, length-1);
		}else {
			if(array[0]>array[1]) {
				swap(array, 0 ,1);
			}
		}

		return array;
	}

	public void quickSort_recursive(int[] array, int left, int right) {
		if (right - left > 1) {
			// get pivot
			int pivot = getPivot(array, left, right);
			// divide the array based on the pivot value
			// if an element is smaller or equal to pivot, take it to the left side
			// if an element is larger than pivot, take it to the right side
			int i = left + 1;
			int j = right - 1;
			while (true) {
				while (array[i] <= pivot && i < right) {
					i++;
				}
				while (array[j] > pivot && j > left) {
					j--;
				}
				if (i < j) {
					swap(array, i, j);
				} else {
					// swap finished
					break;
				}
			}
			// take the pivot to the proper position
			swap(array, i, right);
			quickSort_recursive(array, left, i-1);
			quickSort_recursive(array, i + 1, right);

		}else if(right - left == 1) {
			if(array[right]<array[left]) {
				swap(array,right,left);
			}
		}else {
			return;
		}
	}

	public void swap(int[] A, int a, int b) {
		int temp = A[b];
		A[b] = A[a];
		A[a] = temp;
	}

	public int getPivot(int[] A, int left, int right) {
		int median = (right + left) / 2;
		if (A[left] > A[median]) {
			swap(A, left, median);
		}
		
		if (A[left] > A[right]) {
			swap(A, left, right);
		}

		if (A[median] > A[right]) {
			swap(A, median, right);
		}

		// take the select pivot on the position of right-1
		swap(A, median, right);

		return A[right];
	}
}