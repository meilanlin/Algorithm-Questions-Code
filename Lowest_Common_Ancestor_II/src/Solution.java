/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5
       / \
      9   12
     / \   \
    2   3   14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
https://app.laicode.io/app/problem/127
 */
/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // corner case
    if(one == null || two == null) return null;

    int oneHeight = getHeight(one);
    int twoHeight = getHeight(two);

    while(oneHeight < twoHeight){
      two = two.parent;
      twoHeight--;
    }
    
    while(twoHeight < oneHeight){
      one = one.parent;
      oneHeight--;
    }

    while(one != two){
      one = one.parent;
      two = two.parent;
    }

    return one;
  }

  public int getHeight(TreeNodeP one){
    int height = 0;
    while(one != null){
      one = one.parent;
      height++;
    }
    return height;
  } 
}