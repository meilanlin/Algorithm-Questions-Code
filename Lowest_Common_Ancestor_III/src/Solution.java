/*
Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree

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
https://app.laicode.io/app/problem/128
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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // corner case
    if(one == null || two == null) return null;

    TreeNode result = helper(root, one, two);
    // if result != null, then we need to check whether result equals one or two
    if(result != null){
      // if not, it means both one and two belong an common parent node
      if(result != one && result != two) return result;
      // if result equals one or two, then there are two situations
      // 1. one node is the parent node of other node
      // 2. there is one node not exists in the tree
      if(result == one && hasOtherNode(one, two)) return one;
      if(result == two && hasOtherNode(two, one)) return two;
    }

    // if result == null, return null
    // if one node is not exist, return null
    return null;
  }

  public boolean hasOtherNode(TreeNode root, TreeNode node){
    // base case
    if(root == null) return false;

    if(root == node) return true;

    boolean left = hasOtherNode(root.left, node);
    boolean right = hasOtherNode(root.right, node);

    return left || right;
  }


  public TreeNode helper(TreeNode root, TreeNode one, TreeNode two){
    // base case
    if(root == null || root == one || root == two) return root;

    TreeNode left = helper(root.left, one, two);
    TreeNode right = helper(root.right, one, two);

    if(left != null && right != null) return root;
    return left == null ? right : left;
  }
}