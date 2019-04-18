import java.util.Comparator;
import java.util.PriorityQueue;
/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions
the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M

Examples
{ {1, 3, 5,  7 },
  {2, 4, 8,  9 },
  {3, 5, 11, 15},
  {6, 8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
 */
public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Important: ask the clarify that is the kth contains the duplicated number
    // Important: you must first to know the k starts from 0 or 1
    // Important: Base Case
    if(k == 1) return matrix[0][0];
    
    //=========initial=========
    int matrixRow = matrix.length;
    int matrixCol = matrix[0].length;
    // create a boolean array to store the elements that visited
    boolean[][] visited = new boolean[matrixRow][matrixCol];
    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2){
        if(c1.val == c2.val) return 0;
        // notice: there is c1.val > c2.val, not c1 > c2
        return c1.val > c2.val ? 1:-1; 
      }
     });

    // because this question consider duplication, so we don't need care about it
    // if we don't want take the duplication number, then we need an array to record which number already took
    // because we always get the min value from the current heap and add it to the generated array
    // so the elements in the generated[] must be ascending order. 
    // then we can check the last element of the generated[] to know whether this value has been generated
    //int[] generated = new int[k];

    minHeap.offer(new Cell(0,0,matrix[0][0]));
    visited[0][0] = true;
    //generated[0] = matrix[0][0];
    
    ////=========Expand=========
    int count = 0;
    while(!minHeap.isEmpty()){
      int size = minHeap.size();
      for(int i = 0; i < size; i++){
        Cell cur = minHeap.poll();
       
        // notice; here is k - 1
        if(count++ == k - 1) return cur.val; 
        
        int val = cur.val;
        int col_position = cur.col;
        int row_position = cur.row;
        
        //check out of bound & check whether visited
        if(col_position < matrixCol - 1 && !visited[row_position][col_position + 1]){
            Cell right = new Cell(row_position,col_position + 1,matrix[row_position][col_position + 1]);
            minHeap.offer(right);
            // change the visited status
            visited[row_position][col_position + 1] = true;
        }
        //check out of bound && check whether visited
        if(row_position < matrixRow - 1 && !visited[row_position + 1][col_position]){
            Cell down = new Cell(row_position + 1, col_position, matrix[row_position + 1][col_position]);
            minHeap.offer(down);
            // change the visited status
            visited[row_position + 1][col_position] = true;
        }
      }
    }
    return 0;
  }
  
  static class Cell {
    int row;
    int col;
    int val;
    
    Cell(int row, int col, int val){
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }
}
