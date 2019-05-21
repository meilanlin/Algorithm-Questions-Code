/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions

N > 0
Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
https://app.laicode.io/app/problem/233
*/
public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here
    boolean[][] matrix = new boolean[n][n];
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur_result = new ArrayList<>();
    
    // corner case
    if(n == 0) {
        result.add(cur_result);
        return result;
    }

    helper(n, 0, matrix, result, cur_result);
    return result;
  }

  public void helper(int n, int row, boolean[][] matrix, List<List<Integer>> result, List<Integer> cur_result){
      // base case
      if(row == n){
        // notice that there should put the cur_result into a new variable
    	// else the cur_result will be changed
        result.add(new ArrayList<Integer>(cur_result));
        return;
      }

      for(int i = 0; i < n; i++){
          // check the avaiable position in current row
          if(matrix[row][i] == false){
             cur_result.add(i);
             // since the array point to the reference, so we need to copy the matrix to the new one
             boolean[][] new_matrix = new boolean[n][n];
             int j = 0;
             for(boolean[] ele : matrix){
                new_matrix[j++] = ele.clone();
             }
             // change the status of other position
             changeStatus(row, i, new_matrix, n);
             helper(n, row + 1, new_matrix, result, cur_result);
             // delete the current selection and renew the matrix to the pervious one
             cur_result.remove(row);    
          }
      }
  }

  public void changeStatus(int original_row, int original_column, boolean[][] matrix, int n){
    // change the value of current row and column to true
    for(int i = 0; i < n; i++){
        matrix[original_row][i] = true;
        matrix[i][original_column] = true;
    }
    // you must give a new variable to store row and column unless the value will be changed after the first while loop
    // but each loop required the original row and column value.
    // first direction: up and right
    int row = original_row;
    int column = original_column;
    while(row >= 0 && column < n ){
        matrix[row--][column++] = true;
    }
    // second direction: down and left
    row = original_row;
    column = original_column;
    while(row < n  && column >= 0){
        matrix[row++][column--] = true;
    }
    // third direction: up and left
    row = original_row;
    column = original_column;
    while(row >= 0 && column >= 0){
        matrix[row--][column--] = true;
    }
    // fourth direction: down and right
    row = original_row;
    column = original_column;
    while(row < n && column < n){
        matrix[row++][column++] = true;
    }
  }
}
