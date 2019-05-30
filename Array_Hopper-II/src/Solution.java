public class Solution {
  public int minJump(int[] array) {
    // corner case
    if(array.length == 0) return 0;
    // if int[] = {0}, this line is not work
    //if(array.length == 1) return 1;

    int[] M = new int[array.length];
    // base case
    M[array.length - 1] = 0;
    // induction rule
    for(int i = array.length - 2; i >= 0; i--){
        int number = array[i];
        int j = 1;
        int temp = Integer.MAX_VALUE;
        while(j <= number && i + j < array.length){
            if(M[i+j] != -1){
                temp = Math.min(temp, M[i+j]); 
            }  
        j++;    
        }
        if(temp != Integer.MAX_VALUE){
            M[i] = temp + 1;
        }else{
            M[i] = -1;
        }  
    }
    return M[0];
  }
}
