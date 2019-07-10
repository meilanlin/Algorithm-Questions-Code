/*
Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

the corresponding binary search tree is

        5
       / \
      3   8
     / \   \
    1   4   11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

    1
   / \
  2   3
     /
    4
https://app.laicode.io/app/problem/211
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
  private int index = 0;
  public TreeNode reconstruct(int[] post) {
    
    index = post.length - 1;
    TreeNode root = helper(post, Integer.MIN_VALUE);
    return root;
  }

  public TreeNode helper(int[] post, int min){
    // base case
    if(index < 0 || post[index] < min) return null;

    TreeNode root = new TreeNode(post[index--]);
    TreeNode right = helper(post, root.key);
    TreeNode left = helper(post, min);
    root.right = right;
    root.left = left;
    return root;
  }
}
