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
            // �����ھ����Եʱ����Ϊ�ܱ�û�п��ԱȽϵĵ㣬��λ�õ�ֵ����������
            if(j == 0 || i == 0) {
                M[i][j] = matrix[i][j];
            }else{
                // �ֱ�ӵ�ǰ������������Ͻǵ�ֵ���жϣ���Щ��ֱ������������Ϊsquare���½�����ɵ�square�ĳ��Ϳ�
                int min = getMin(M[i][j-1], M[i-1][j], M[i-1][j-1]);
                // ֻ���ڵ�ǰ��ҲΪ1ʱ���ſ���+1������ǰ����Ϊsquare���½�ʱ���square�ĳ���
                // �ڵ�ǰ��Ϊ1ʱ���Ե�ǰ����Ϊ���½ǵ�square�ǲ����ڵ�
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
