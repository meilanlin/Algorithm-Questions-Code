/*
Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node¡¯s left and right subtree differ by at most 1.

Examples
        5
       / \
      3   8
     / \   \
    1   4   11

is balanced binary tree,
        5
       /
      3
     / \
    1   4

is not balanced binary tree.

Corner Cases
What if the binary tree is null? Return true in this case.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example: The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1
   / \
  2   3
     /
    4
https://app.laicode.io/app/problem/46
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
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1) {
			return false;
		}

		boolean leftBalanced = isBalanced(root.left);
		boolean rightBalanced = isBalanced(root.right);

		return leftBalanced && rightBalanced;
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		int height = Math.max(leftHeight, rightHeight);
		return height + 1;
	}
}