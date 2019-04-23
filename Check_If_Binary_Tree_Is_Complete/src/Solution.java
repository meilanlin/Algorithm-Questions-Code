import java.util.LinkedList;
import java.util.Queue;

/*
Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

Examples
        5
       / \
      3   8
     / \
    1   4

is completed.
        5
       / \
      3   8
     / \   \
    1   4   11

is not completed.

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
https://app.laicode.io/app/problem/47
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
  public boolean isCompleted(TreeNode root) {
    // 这个base case必不可少
    if(root == null){
      return true;
    }
    // 记住是向queue里面offer新node，不是往node里offer新node
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    int size = 0;
    boolean hasNull = false;
    // 如果这是一个完全二叉树，那null只能聚集在右下部。
    // 那么如果在遍历过程中发现了一个null，只要检测其后有没有非null节点即可
    while(!q.isEmpty()){
      size = q.size();
      for(int i = 0; i < size; i++){
        TreeNode node = q.poll();
        if(node.left != null){
          if(hasNull) return false;
          q.offer(node.left);
        }else{
          hasNull = true;
        }
        
        if(node.right != null){
          if(hasNull) return false;
          q.offer(node.right);
        }else{
          hasNull = true;
        }
        
      }
    }
    return true;
  }
}
