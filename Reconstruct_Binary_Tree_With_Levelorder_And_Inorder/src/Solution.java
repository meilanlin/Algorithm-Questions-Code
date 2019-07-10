/*
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5
       / \
      3   8
     / \   \
    1   4   11

How is the binary tree represented?

We use  level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1
   / \
  2   3
     /
    4
https://app.laicode.io/app/problem/215
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
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    List<Integer> level = new ArrayList<>();
    for(int val : levelOrder){
      level.add(val);
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++){
      map.put(inOrder[i], i);
    }
    TreeNode root = helper(level, map);
    return root;
  }

  public TreeNode helper(List<Integer> level, Map<Integer, Integer> map){
    // base case
    if(level.size() == 0) return null;

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    TreeNode root = new TreeNode(level.remove(0));
    for(int num : level){
      if(map.get(num) < map.get(root.key)){
        left.add(num);
      }
      // becasue 5 has been removed, so we don't need to worried about map.get(num) = map.get(root.key)
      if(map.get(num) >= map.get(root.key)){
        right.add(num);
      }
    }

    root.left = helper(left, map);
    root.right = helper(right, map);
    return root;
  }
}
