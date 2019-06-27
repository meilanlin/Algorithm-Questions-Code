/*
Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.

Assumptions

There are no duplicate keys in the binary search tree
https://app.laicode.io/app/problem/52
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
  public TreeNode search(TreeNode root, int key) {
    if(root == null) return root;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int size = queue.size();
    while(size != 0){
      TreeNode node = queue.poll();
      if(node.key == key) return node;
      if(node.key < key && node.right != null){
        queue.offer(node.right);
      }else if(node.key > key && node.left != null){
        queue.offer(node.left);
      }
      size = queue.size();
    }
    return null;
  }
}
