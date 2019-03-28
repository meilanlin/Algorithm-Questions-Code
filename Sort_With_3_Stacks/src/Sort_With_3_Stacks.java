import java.util.LinkedList;

/*
Given one stack with integers, sort it with two additional stacks (total 3 stacks). 
After sorting the original stack should contain the sorted integers 
and from top to bottom the integers are sorted in ascending order.

Assumptions: The given stack is not null.

Requirements: No additional memory, time complexity = O(nlog(n)).
 */

public class Sort_With_3_Stacks {
	public static void main(String[] args) {
		LinkedList<Integer> s1 = new LinkedList<Integer>();
		s1.push(1);
		s1.push(3);
		s1.push(2);
		s1.push(7);
		s1.push(2);
		s1.push(3);
		sort(s1);
	}

	public static void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		// Write your solution here.
		while (!s1.isEmpty()) {
			int globalMin = searchGlobalMin(s1, s2);
			sortElement(s1, s2, s3, globalMin);
		}
	}

	public static void sortElement(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int min) {
		while (!s2.isEmpty()) {
			int ele = s2.pop();
			if (ele == min) {
				s3.push(ele);
			} else {
				s1.push(ele);
			}
		}
	}

	public static int searchGlobalMin(LinkedList<Integer> s1, LinkedList<Integer> s2) {
		int globalMin = Integer.MAX_VALUE;
		while (!s1.isEmpty()) {
			int ele = s1.pop();
			if (ele < globalMin) {
				globalMin = ele;
			}
			s2.push(ele);
		}
		return globalMin;
	}
}
