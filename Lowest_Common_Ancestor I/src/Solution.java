/*
Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

Examples

        5
       / \
      9   12
     / \    \
    2   3    14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9
https://app.laicode.io/app/problem/126
 */
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,TreeNode one, TreeNode two) {
    // base case
    if(root == null) return root;
    if(root == one) return one;
    if(root == two) return two;

    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);

    // if all two target number were found
    if(left != null && right != null){
      return root;
    }else if(left != null && right == null){
    // if find one target number from left
     return left;
    }else if(left == null && right != null){
    // if find one target number from right
      return right;
    }   
    
    // if do not find the target number
    return null;
  }
}