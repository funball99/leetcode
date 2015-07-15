package problems234;

import java.util.Stack;

/**
 * 2015-7-10
 * 
 * @author wilson
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		a.next = b;
		b.next = c;
		
		boolean result = new Solution().isPalindrome(a);
		
		System.out.println(result);
		
	}

	public int getLength(ListNode head) {
		int result = 1;
		
		if(head == null){
			return 0;
		}
		
		ListNode thisNode = head;
		while ((thisNode = thisNode.next) != null) {
			result++;
		}

		return result;
	}

	public boolean isPalindrome(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();

		int length = getLength(head);

		for (int i = 0; i < length / 2; i++) {
			stack.push(head.val);
			head = head.next;
		}
		
		if(length%2!=0){
			head = head.next;
		}

		for (int i = (length % 2 == 0) ? (length / 2) : ((length / 2) + 1); i < length; i++) {

			if (stack.pop() == head.val) {
				head = head.next;
				continue;
			} else {
				return false;
			}

		}
		
		
		return true;
	}

}
