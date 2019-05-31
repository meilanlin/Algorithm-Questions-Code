/*
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions

The given matrix is not null and guaranteed to be of size N * N, N >= 0
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1}}

the largest square of 1s has length of 2

https://app.laicode.io/app/problem/101
 */
public class Solution {
  public int largest(int[][] matrix) {
    if(matrix.length == 0 && matrix.length == 0) return 0;
    if(matrix.length == 1 && matrix.length == 1) return matrix[0][0];
    int globalMax = 0;
    int[][] M = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < matrix.length; i++){
        // go through each element of the row
        for(int j = 0; j < matrix[0].length; j++){
            // 当点在矩阵边缘时，因为周边没有可以比较的点，此位置的值就是它本身
            if(j == 0 || i == 0) {
                M[i][j] = matrix[i][j];
            }else{
                // 分别从当前点的左，上与左上角的值来判断，这些点分别代表着它们作为square右下角所组成的square的长和宽
                int min = getMin(M[i][j-1], M[i-1][j], M[i-1][j-1]);
                // 只有在当前点也为1时，才可以+1，代表当前点作为square右下角时这个square的长宽
                // 在当前点为1时，以当前点作为右下角的square是不存在的
                if(matrix[i][j] == 1){
                    M[i][j] = min + matrix[i][j];
                }else{
                    M[i][j] = matrix[i][j];
                }
            }
            if(globalMax < M[i][j]) globalMax = M[i][j];
        }
    }
    return globalMax;
  }

  public int getMin(int a, int b, int c){
      int temp = Math.min(a, b);
      return Math.min(temp, c);
  }
}
