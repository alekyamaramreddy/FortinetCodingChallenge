package arrays;

public class Solution {
	public ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode cur = head;

		if (cur == null || cur.next == null) {
			return cur;
		}

		Object fut = cur.next;
		while (cur.next != null) {
			cur.next = prev;
			prev = cur;
			cur = fut;
			fut = fut.next;
		}

		cur.next = prev;

		return cur;

	}
}
