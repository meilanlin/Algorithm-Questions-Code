class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	  public ListNode insert(ListNode head, int value) {
	    // Write your solution here
	    // create a dummyHead to build a new list
	    ListNode dummyHead = new ListNode(-1);
	    ListNode newNode = new ListNode(value);
	    // justify if the head value is larger than input value
	    if(head == null || head.value > value){
	      dummyHead.next = newNode;
	      newNode.next = head;
	      return newNode; //因为head在后，所以应该返回newNode
	    }

	    // justify where the input value should input
	    ListNode cur = head;
	    dummyHead.next = head;
	    while(cur.next!=null){
	      if(cur.next.value > value){
	        ListNode next = cur.next;
	        cur.next = newNode;
	        newNode.next = next;
	        return head;
	      }else{
	        cur = cur.next;
	      }
	    }
	    // if all nodes are smaller than value
	    cur.next = newNode;
	    newNode.next = null;
	    return head;
	  }
	}