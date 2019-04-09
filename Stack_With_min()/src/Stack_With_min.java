import java.util.LinkedList;

/*
Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. 
If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1
push(int element) - push the element to top
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
https://app.laicode.io/app/problem/32
 */


public class Stack_With_min {
  LinkedList<Integer> in;
  LinkedList<Integer> out;
  public Stack_With_min() {
    // write your solution here
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  
  // pop() - remove and return the top element, if the stack is empty, return -1
  public int pop() {
    if(in.isEmpty()){
      return -1;
    }
    out.pollFirst();
    return in.pollFirst();
  }
  
  // push the element into the in
  // meanwhile check the min element from the out
  // push the min element into the out
  public void push(int element) {
    in.offerFirst(element);
    if(!out.isEmpty()){
      int min = out.peek();
      if(min >= element){
         out.offerFirst(element); // for a stack implemented by the linkedlist, the head and tail is defined by us.
      }else{
        out.offerFirst(min);
      }
    }else{
      out.offerFirst(element);
    }
  }
  
  // top() - return the top element without remove it, if the stack is empty, return -1
  public int top() {
    if(in.isEmpty()){
      return -1;
    }
    return in.peek();
  }
  
  // min() - return the current min value in the stack.
  public int min() {
    if(in.isEmpty()){
      return -1;
    }
    return out.peek();
  }
  
}