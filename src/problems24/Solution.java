package problems24;




/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月8日 下午4:47:43
 */


/*
 * 
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 
 *
 */

public class Solution {
	
	/*
	 * 基本思路:
	 * 就一个递归。。2个一组，很清晰
	 */
	public ListNode swapPairs(ListNode head) {
		
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode tmp = head.next;
		
		head.next = tmp.next;
		tmp.next = head;
		head.next = swapPairs(tmp.next.next);
		return tmp;
    }
	
	
	public static class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next =c ;
		c.next= d;
		d.next = null;
		
		System.out.println(new Solution().swapPairs(a));
	}
}
