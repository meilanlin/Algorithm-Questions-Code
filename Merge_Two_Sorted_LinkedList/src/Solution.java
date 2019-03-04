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

		// ʹ��else���������������������º���Ĵ��벻���ܱ�ִ��
		// �ᱨ�� unreachable statement
		// else{
		// return null;
		// }

		ListNode dummyHead = new ListNode(-1);
		ListNode dummyCur = dummyHead;
		// ע��while����!=����Ҫ˳��д����==, Ӧ����&&,��Ӧ����||
		// ���ﲻӦ����while(cur_one.next != null && cur_two.next != null){
		// ����while(cur_one != null && cur_two != null){
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
