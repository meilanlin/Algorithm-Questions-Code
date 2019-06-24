/*
Print all node values in a tree in level order. Assumption: The tree is not null or empty.

Example:
        7
      /   \
     5     4
   /   \
  3     6
       /
      1

Answer: [7,5,4,3,6,1]
https://app.laicode.io/app/problem/566
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
  public List<Integer> bfs(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);
    int size = queue.size();
    
    while(size > 0){
      for(int i = 0; i < size; i++){
        TreeNode node = queue.poll();
        result.add(node.key);
        if(node.left != null) queue.offer(node.left);
        if(node.right != null) queue.offer(node.right);
      }
      size = queue.size();
    }
    return result;
  }
}
