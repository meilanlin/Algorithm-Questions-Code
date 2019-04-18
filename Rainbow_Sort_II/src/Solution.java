public class Solution {
  public int[] rainbowSortII(int[] array) {
    // Write your solution here
    int[] note = new int[4];
    for(int color : array){
      if(color == 0) note[0] = note[0] + 1;
      if(color == 1) note[1] = note[1] + 1;
      if(color == 2) note[2] = note[2] + 1;
      if(color == 3) note[3] = note[3] + 1;
    }
    
    int index = 0;
    for(int i = 0; i< note.length; i++){
      int count = note[i];
      while(count != 0){
        array[index++] = i;
        count --;
      }
    }
    return array;
  }
}
