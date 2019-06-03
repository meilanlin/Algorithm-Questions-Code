/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.
https://app.laicode.io/app/problem/104
 */
public class Solution {
  public int largest(int[][] matrix) {
    //corner case
    // 不能使用if(row == 0 && col == 0) 因为如果row=0，col就不存在。会出现arrayIndexOutOfBound
    //if(row == 0 && col == 0) return 0;
    int row = matrix.length;
    if(row == 0) return 0;
    int col = matrix[0].length;

    // use four direction to calculate the maximum consecutive 1s
    int[][] left = new int[row][col]; // from left to right
    int[][] right = new int[row][col]; // from right to left
    int[][] top = new int[row][col];  // from up to botom
    int[][] bottom = new int[row][col]; // from bottom to up

    initialLeft(left, matrix);
    initialRight(right, matrix);
    initialTop(top, matrix);
    initialBottom(bottom, matrix);

    int globalMax = 0;
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        int armLength = getMin(left[i][j], right[i][j], top[i][j], bottom[i][j]);
        if(globalMax < armLength) globalMax = armLength;
      }
    }
    return globalMax;
  }
  public int getMin(int a, int b, int c, int d){
    int temp = Math.min(a, b);
    int temp2 = Math.min(temp, c);
    return Math.min(temp2, d);
  }
  public void initialLeft(int[][] M, int[][] matrix){
    for(int i = 0; i < matrix.length; i++){
      int localMax = 0;
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j] == 1){
          localMax++;
        }else{
          localMax = 0;
        }
        M[i][j] = localMax;
      }
    }
  }

  public void initialRight(int[][] M, int[][] matrix){
    for(int i = 0; i < matrix.length; i++){
      int localMax = 0;
      for(int j = matrix[0].length - 1; j >= 0; j--){
        if(matrix[i][j] == 1){
          localMax++;
        }else{
          localMax = 0;
        }
        M[i][j] = localMax;
      }
    }
  }

  public void initialTop(int[][] M, int[][] matrix){
    for(int j = 0; j < matrix[0].length; j++){
      int localMax = 0;
      for(int i = 0; i < matrix.length; i++){
        if(matrix[i][j] == 1){
          localMax++;
        }else{
          localMax = 0;
        }
        M[i][j] = localMax;
      }
    }
  }
  
  public void initialBottom(int[][] M, int[][] matrix){
    for(int j = 0; j < matrix[0].length; j++){
      int localMax = 0;
      for(int i = matrix.length - 1; i >= 0; i--){
        if(matrix[i][j] == 1){
          localMax++;
        }else{
          localMax = 0;
        }
        M[i][j] = localMax;
      }
    }
  }

}
