
public class Solution {
	public int[] bubbleSort(int[] array) {
		if(array == null || array.length<=1) {
			return array;
		}
		
		int endPoint = array.length-1;
		
		while(endPoint>0) {
			int pos = endPoint;
			for(int j = 1; j<=endPoint;j++) {
				if(array[j-1]>array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					pos = j;
				}
			}
			endPoint = pos - 1;
		}
		return array;
	}
}
