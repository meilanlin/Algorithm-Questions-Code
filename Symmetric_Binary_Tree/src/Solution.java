/*
Check if a given binary tree is symmetric.

Examples

        5
       / \
      3   3
     / \  / \
    1   4 4  1    is symmetric.

        5
       / \
      3   3
     / \  / \
    1  4 1   4    is not symmetric.

Corner Cases

What if the binary tree is null? Return true in this case.

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
   1
  / \
 2   3
    /
   4
https://app.laicode.io/app/problem/48
 */
class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}
}

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else if (left.key != right.key) {
			return false;
		}

		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}
