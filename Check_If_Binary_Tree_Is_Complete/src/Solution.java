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
    // ���base case�ز�����
    if(root == null){
      return true;
    }
    // ��ס����queue����offer��node��������node��offer��node
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    int size = 0;
    boolean hasNull = false;
    // �������һ����ȫ����������nullֻ�ܾۼ������²���
    // ��ô����ڱ��������з�����һ��null��ֻҪ��������û�з�null�ڵ㼴��
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
