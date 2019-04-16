import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.

Examples
        5
       / \
      3   8
     / \   \
    1   4   11

the result is [ [5], [3, 8], [1, 4, 11] ]

Corner Cases
What if the binary tree is null? Return an empty list of list in this case.

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
   1
  / \
 2   3
    /
   4
https://app.laicode.io/app/problem/57
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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // Write your solution here
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if(root == null){
      return result;
    }
    
    int size = 0;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    while(!queue.isEmpty()){
      size = queue.size();
      List<Integer> tmp = new LinkedList<Integer>();
      // finish the nodes in the current level
      for(int i = 0; i<size; i++){
        TreeNode node =  queue.poll();
        if(node.left != null) queue.offer(node.left);
        if(node.right != null) queue.offer(node.right);
        tmp.add(node.key);
      }
      result.add(tmp);
    }
    return result;
  }
}
