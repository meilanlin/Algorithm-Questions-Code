/*
Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of N * N where N >= 0
Examples

{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
https://app.laicode.io/app/problem/121
 */
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // corner case
    List<Integer> list = new ArrayList<Integer>();
    helper(list, matrix, 0, 0, matrix.length * matrix[0].length);
    return list;
  }

  public void helper(List<Integer> list, int[][] matrix, int i, int j, int size){
    int row = matrix.length - i;
    int col = matrix[0].length - j;
    int j_end_position = j;
    // base case
    if(size <= 1){
      if(size == 1) list.add(matrix[i][j]);  
      return;
    }

    int count = 0;
    int i_end_position;
    while(j < col){
      list.add(matrix[i][j++]);
      count++;
    }
    j--;
    
    i++;
    while(i < row){
      list.add(matrix[i++][j]);
      count++;
    }
    i--;
    i_end_position = matrix.length - i;

    j--;
    while(j >= j_end_position){
      list.add(matrix[i][j--]);
      count++;
    }
    j++;

    i--;
    while(i >= i_end_position){
      list.add(matrix[i--][j]);
      count++;
    }
    i++;

    helper(list, matrix, i, j+1, size - count);
    return;

  }
}
