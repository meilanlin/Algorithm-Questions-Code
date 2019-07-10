/*
Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

preorder traversal = {5, 3, 1, 4, 8, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5
       / \
      3   8
     / \   \
    1   4   11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:

    1
   / \
  2   3
     /
    4
https://app.laicode.io/app/problem/213
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
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    for(int val : inOrder){
      map.put(val,index++);
    }
    TreeNode root = helper(inOrder, preOrder, 0, inOrder.length - 1, 0, map);
    return root;
  }

  public TreeNode helper(int[] inOrder, int[] preOrder, int inLeft, int inRight, int preLeft, Map<Integer, Integer> map){
    // base case
    if(inLeft > inRight) return null;

    int cur = preOrder[preLeft];
    int leftSize = map.get(cur) - inLeft;
    TreeNode node = new TreeNode(cur);

    TreeNode left = helper(inOrder, preOrder, inLeft, inLeft + leftSize - 1, preLeft + 1, map);
    TreeNode right = helper(inOrder, preOrder, inLeft + leftSize + 1, inRight, preLeft + leftSize + 1 , map);

    node.left = left;
    node.right = right;
    return node;
  }
}
