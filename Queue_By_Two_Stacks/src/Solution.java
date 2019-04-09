import java.util.LinkedList;

/*
Java: Implement a queue by using two stacks. 
The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
When the queue is empty, poll() and peek() should return null.

Assumptions
	The elements in the queue are all Integers.
	size() should return the number of elements buffered in the queue.
	isEmpty() should return true if there is no element buffered in the queue, false otherwise.
	https://app.laicode.io/app/problem/31
 */

public class Solution {
	private LinkedList<Integer> in;
	private LinkedList<Integer> out;

	public Solution() {
		// Write your solution here.
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	// remove the first element
	public Integer poll() {
		// check if the out stack has element
		if (checkStackHasEle()) {
			// when out has element, pop it
			return out.pop();
		}
		return null;
	}

	public void offer(int element) {
		in.push(element);
	}

	// search the first element, if it's empty,return null.
	public Integer peek() {
		// check if the out stack has element
		if (checkStackHasEle()) {
			// when out has element, peek the first one
			return out.peekFirst();
		}
		return null;
	}

	public int size() {
		// if stack is null, the size() will return 0.
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		// cannot ust int total = in.size() + out,size();
		// because the stack may is null and the total cannot received any value
		return in.isEmpty() && out.isEmpty();
	}

	public boolean checkStackHasEle() {
		if (out.isEmpty()) {
			if (!in.isEmpty()) {
				// when out is empty and in not, give elements from in to out
				while (!in.isEmpty()) {
					out.push(in.pop());
				}
			} else {
				// if no element in two stacks, return null
				return false;
			}
		}
		return true;
	}
}
