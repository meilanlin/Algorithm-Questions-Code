/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
https://app.laicode.io/app/problem/87
 */
public class Solution {
  public int maxProduct(int length) {
    // Write your solution here
    // corner case
    if(length == 0 || length == 1) return 1;

    int[] products = new int[length+1];
    products[0] = 1;
    products[1] = 1;

    int curProduct = 1;
    int curMax = 1;
    for(int i = 1; i <= length; i++){   
        for(int j = 1; j <= i - 1; j++){
            // for every section after cutting, we need compare the product with 
            // cutting this section with the value without cutting this section
            curProduct = Math.max(products[j],j) * Math.max(products[i-j],i-j);
            curMax = Math.max(curMax,curProduct);
        }
        products[i] = curMax;
    }
    return products[length];
  }
}
