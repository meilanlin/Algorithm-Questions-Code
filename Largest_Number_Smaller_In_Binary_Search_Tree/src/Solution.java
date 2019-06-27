/*
In a binary search tree, find the node containing the largest number smaller than the given target number.

If there is no such number, return -2^31.

Assumptions:
The given root is not null.
There are no duplicate keys in the binary search tree.

Examples
    5
   / \
  2   11
     /  \
    6    14

largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
largest number smaller than 10 is 6
largest number smaller than 6 is 5

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1
   / \
  2   3
     /
    4
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
  public int largestSmaller(TreeNode root, int target) {
    int global = Integer.MIN_VALUE;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int size = queue.size();
    while(size != 0){
      TreeNode node = queue.poll();
      if(node.key >= target && node.left != null){
        queue.offer(node.left);
      // if there is (node.key < target && node.right != null), 
      // then when the leaf node is the answer, it will not update on global 
      // because this block is invalid and will be skiped
      }else if(node.key < target){
        if(node.key > global) global = node.key;
        if(node.right != null) queue.offer(node.right);
      }
      size = queue.size();
    }
    return global;
  }
}
