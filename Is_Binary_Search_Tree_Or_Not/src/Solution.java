/*
Determine if a given binary tree is binary search tree.There should no be duplicate keys in binary search tree.

Assumptions

You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
Corner Cases

What if the binary tree is null? Return true in this case.
https://app.laicode.io/app/problem/54
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
	public boolean isBST(TreeNode root) {
		// Write your solution here
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return check(root, min, max);
	}

	public boolean check(TreeNode node, int inf_min, int inf_max) {
		if (node == null) {
			return true;
		}
		// BST cannot has two nodes with the same values
		if (node.key <= inf_min || node.key >= inf_max) {
			return false;
		}

		boolean left = check(node.left, inf_min, node.key);
		boolean right = check(node.right, node.key, inf_max);
		return left && right;
	}
}
