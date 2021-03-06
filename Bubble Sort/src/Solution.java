
public class Solution {
	public int[] bubbleSort(int[] array) {
		if(array == null || array.length<=1) {
			return array;
		}
		
		for(int i = 0;i<array.length;i++) {
			for(int j = 1;j<array.length;j++) {
				if(array[j-1]>array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
