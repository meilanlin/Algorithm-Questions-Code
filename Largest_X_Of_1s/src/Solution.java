/*
Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest X shape.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest X of 1s has arm length 2.
https://app.laicode.io/app/problem/105
 */
public class Solution {
  public int largest(int[][] matrix) {
    int row = matrix.length;
    if(row == 0) return 0;
    int col = matrix[0].length;

    // use four directions
    int[][] top_left = new int[row][col]; // from topleft to bottomright
    int[][] top_right = new int[row][col]; // from topright to bottom left
    int[][] bottom_left = new int[row][col];// from bottomleft to topright
    int[][] bottom_right = new int[row][col];// from bottomright to topleft

    initialTopLeft(top_left, matrix);
    initialTopRight(top_right, matrix);
    initialBottomLeft(bottom_left, matrix);
    initialBottomRight(bottom_right, matrix);

    // find the largest arm
    int globalMax = 0;
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        int armLength = getMin(top_left[i][j],top_right[i][j],bottom_left[i][j],bottom_right[i][j]);
        globalMax = Math.max(globalMax, armLength);
      }
    }
    return globalMax;
  }

  public void initialTopLeft(int[][] M, int[][] matrix){
    // for first row 
    for(int j = 0; j < matrix[0].length; j++){
      int i = 0;
      int localMax = 0;
      int origin_j = j;
      while(i < matrix.length && j < matrix[0].length){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;

        M[i][j] = localMax;
        i++;
        j++;
      }
      j = origin_j;
    }

    // for first column except the element in first row
    for(int i = 1; i < matrix.length; i++){
      int j = 0;
      int localMax = 0;
      int origin_i = i;
      while(i < matrix.length && j < matrix[0].length){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        i++;
        j++;
      }
      i = origin_i;
    }
  }

  public void initialTopRight(int[][] M, int[][] matrix){
    // for first row
    for(int j = 0; j < matrix[0].length; j++){
      int i = 0;
      int localMax = 0;
      int origin_j = j;
      while(i < matrix.length && j >= 0){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        j--;
        i++;
      }
      j = origin_j;
    }

    // for the last column except the element in first row
    for(int i = 1; i < matrix.length; i++){
      int j = matrix[0].length - 1;
      int localMax = 0;
      int origin_i = i;
      while(i < matrix.length && j >= 0){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        i++;
        j--;
      }
      i = origin_i;
    }
  }

  public void initialBottomLeft(int[][] M, int[][] matrix){
    // for the last row
    for(int j = 0; j < matrix[0].length; j++){
      int i = matrix.length - 1;
      int localMax = 0;
      int origin_j = j;
      while(i >= 0 && j < matrix[0].length){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        j++;
        i--;
      }
      j = origin_j;
    }

    // for the first column excep the element in the last row
    for(int i = matrix.length - 2; i >= 0; i--){
      int j = 0;
      int localMax = 0;
      int origin_i = i;
      while(i >= 0 && j < matrix[0].length){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        i--;
        j++;
      }
      i = origin_i;
    }
  }

  public void initialBottomRight(int[][] M, int[][] matrix){
    // for last row
    for(int j = 0; j < matrix[0].length; j++){
      int i = matrix.length - 1;
      int localMax = 0;
      int origin_j = j;
      while(i >= 0 && j >= 0){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        i--;
        j--;
      }
      j = origin_j;
    }

    // for the last column except the element in the last row
    for(int i = matrix.length - 2; i >= 0; i--){
      int j = matrix[0].length - 1;
      int localMax = 0;
      int origin_i = i;
      while(i >= 0 && j>= 0){
        if(matrix[i][j] == 1) localMax++;
        if(matrix[i][j] == 0) localMax = 0;
        M[i][j] = localMax;
        i--;
        j--;
      }
      i = origin_i;
    }
  }

  public int getMin(int a, int b, int c, int d){
    int temp = Math.min(a, b);
    int temp2 = Math.min(temp, c);
    return Math.min(temp2, d);
  }
  
}
