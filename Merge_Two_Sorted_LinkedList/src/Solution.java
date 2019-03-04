class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode merge(ListNode one, ListNode two) {
		if (one == null && two != null) {
			return two;
		} else if (one != null && two == null) {
			return one;
		} else if (one == null && two == null) {
			return null;
		}

		// 使用else会把所有情况都包含，导致后面的代码不可能被执行
		// 会报错 unreachable statement
		// else{
		// return null;
		// }

		ListNode dummyHead = new ListNode(-1);
		ListNode dummyCur = dummyHead;
		// 注意while里是!=，不要顺手写成了==, 应该是&&,不应该是||
		// 这里不应该是while(cur_one.next != null && cur_two.next != null){
		// 而是while(cur_one != null && cur_two != null){
		while (one != null && two != null) {
			if (one.value <= two.value) {
				dummyCur.next = one;
				one = one.next;
			} else {
				dummyCur.next = two;
				two = two.next;
			}
			dummyCur = dummyCur.next;
		}

		if (one != null) {
			dummyCur.next = one;
		} else {
			dummyCur.next = two;
		}

		return dummyHead.next;
	}
}
