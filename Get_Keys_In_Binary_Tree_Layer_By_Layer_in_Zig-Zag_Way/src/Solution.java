import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples
        5
       / \
      3   8
     / \   \
    1   4   11

the result is [5, 3, 8, 11, 4, 1]

Corner Cases
What if the binary tree is null? Return an empty list in this case.

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
   1
  / \
 2   3
    /
   4
https://app.laicode.io/app/problem/58
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
  public List<Integer> zigZag(TreeNode root) {
    // Write your solution here
    List<Integer> result = new LinkedList<Integer>();
    // corner case
    if(root == null){
      return result;
    }
    
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    boolean isZigZag = true;
    while(!q.isEmpty()){
      int size = q.size();
      int[] tmp = new int[size];
      // go through the current node
      for(int i = 0; i < size; i++){
        TreeNode node = q.poll();
        if(node.left != null) q.offer(node.left);
        if(node.right != null) q.offer(node.right);
        tmp[i] = node.key;
      }
      // check whether need to use zig zag order
      if(isZigZag){
        for(int i = size - 1; i >= 0; i--){
          result.add(tmp[i]);
        }
        isZigZag = false;
      }else{
        for(int i = 0; i < size; i++){
          result.add(tmp[i]);
        }
        isZigZag = true;
      }
    }
    
    return result;
  }
}
