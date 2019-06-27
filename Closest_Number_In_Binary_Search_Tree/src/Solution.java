/*
In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:
The given root is not null.
There are no duplicate keys in the binary search tree.

Examples:
    5
   / \
  2   11
     /  \
    6    14

closest number to 4 is 5
closest number to 10 is 11
closest number to 6 is 6

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1
   / \
  2   3
     /
    4
https://app.laicode.io/app/problem/135
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
  public int closest(TreeNode root, int target) {
    int globalDiff = Math.abs(target - root.key);
    int result = root.key;
    // use bfs
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int size = queue.size();
    while(size != 0){
      TreeNode cur = queue.poll();
      if(cur.key == target) return cur.key;

      int localDiff = Math.abs(target - cur.key);
      if(localDiff < globalDiff) {
        globalDiff = localDiff;
        result = cur.key;
      }

      if(cur.key < target && cur.right != null){
        queue.offer(cur.right);
      }else if(cur.key > target && cur.left != null){
        queue.offer(cur.left);
      }
    
      size = queue.size();
    }
    return result;
  }

  
}
