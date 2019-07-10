/*
Find all common elements in 3 sorted arrays.

Assumptions
The 3 given sorted arrays are not null
There could be duplicate elements in each of the arrays

Examples
A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
https://app.laicode.io/app/problem/171
 */
public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> list = new ArrayList<>();
    // corner case
    if(a == null || b == null || c == null || a.length == 0 || b.length == 0|| c.length == 0) return list;
    int indexA = 0;
    int indexB = 0;
    int indexC = 0;
    
    while(indexA < a.length && indexB < b.length && indexC < c.length){
      int valA = a[indexA];
      int valB = b[indexB];
      int valC = c[indexC];

      if(valA == valB && valB == valC){
        list.add(valA);
        indexA++;
        indexB++;
        indexC++;
      }else{
        int min = getMin(valA, valB, valC);
        if(valA == min) indexA++;
        if(valB == min) indexB++;
        if(valC == min) indexC++;
      }
    }

    return list;
  }

  public int getMin(int a, int b, int c){
    int temp = Math.min(a, b);
    return Math.min(temp, c);
  }
}
