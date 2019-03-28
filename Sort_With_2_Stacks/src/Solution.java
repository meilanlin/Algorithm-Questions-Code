import java.util.LinkedList;

/*
Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
After sorting the original stack should contain the sorted integers 
and from top to bottom the integers are sorted in ascending order.

Assumptions: The given stack is not null.

Requirements: No additional memory, time complexity = O(n ^ 2).
 */

public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    while(!s1.isEmpty()){
      findGlobalMin(s1,s2);
    }
    
    // push element from s2 to s1
    while(!s2.isEmpty()){
      s1.push(s2.pop());
    }
  }
  
  public void findGlobalMin(LinkedList<Integer> s1,LinkedList<Integer> s2){
    int min =  Integer.MAX_VALUE; 
    int size = 0;
    int count = 0;
    // find global min value
    while(!s1.isEmpty()){
      int ele = s1.pop();
      if(ele < min){
        min = ele;
      }
      s2.push(ele);
      size ++;
    }
    
    // take values except the global min to s1
    while(size != 0){
      int ele = s2.pop();
      if(ele != min){
        s1.push(ele);
      }else{
        count++;
      }
      size --;
    }
    
    //push global min value to s2
    while(count != 0){
      s2.push(min);
      count --;
    }
      
  }
}
