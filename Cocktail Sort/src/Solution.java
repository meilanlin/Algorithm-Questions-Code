
public class Solution {
    public int[] cocktailSort(int[] array) {
        if (array == null || array.length == 1) {
            return array;
        }

        boolean isSwapped = true;
        while (isSwapped) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                }
            }
            isSwapped = false;
            for (int j = array.length - 2; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j + 1, j);
                    isSwapped = true;
                }
            }

        }
        return array;
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
