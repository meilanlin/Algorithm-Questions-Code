/*
Given a matrix that contains integers, find the submatrix with the largest sum.

Return the sum of the submatrix.

Assumptions

The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
Examples

{ {1, -2, -1, 4},

  {1, -1,  1, 1},

  {0, -1, -1, 1},

  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
https://app.laicode.io/app/problem/106
 */
public class Solution {
  public int largest(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    // corner case
    if(row == 1 && col == 1) return matrix[0][0];
    // M stores the sums of one column with every row
    int[][] M = new int[row][col]; 
    // calculate the prefix sum for each column
    for(int j = 0; j < col; j++){
        int prev = 0;
        for(int i = 0; i < row; i++){
            M[i][j] = matrix[i][j] + prev;
            prev = M[i][j];
        }
    }

    int globalMax = Integer.MIN_VALUE;
    // enumerate each upper and lower rows and get the sums of each column in this range
    for(int upper_row = 0; upper_row < row; upper_row++){
        for(int lower_row = upper_row; lower_row < row; lower_row++){
            // calculate the sum of the sums of columns and find the range with the largest value
            int localMax = findLargestSum(upper_row, lower_row, M, matrix);
            if(globalMax < localMax) globalMax = localMax;
        }
    }
    return globalMax;
  }

  public int findLargestSum(int upper, int lower, int[][] M, int[][] matrix){
    int[] sums = new int[M[0].length];
    for(int j = 0; j < M[0].length; j++){
        int col_sum = M[lower][j] - M[upper][j] + matrix[upper][j];
        sums[j] = col_sum;
    }

    // find the subarray with the largest sum
    int globalMax = Integer.MIN_VALUE;
    int curSum = 0;
    for(int i = 0; i < sums.length; i++){
        if(curSum >= 0){
            curSum = curSum + sums[i];
        }else{
            // 这里不应该是 curSum = sums[0];
            curSum = sums[i];
        }
        //这个if应该放在外面
        if(globalMax < curSum) globalMax = curSum;
    }
    return globalMax;
  }

}
