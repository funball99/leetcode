package problems2;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月20日 上午9:37:43
 */


/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 */
public class Solution {
	
	/*
	 * 基本思路:懒得写了，太简单
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null){
			return null;
		}
		ListNode result = null;
		ListNode now = null;
		int last = 0;
		
        while(l1 != null || l2 != null || last != 0){
        	
        		int var = (l1!=null?l1.val:0) + (l2!=null?l2.val:0);
        		
        		
        		var += last;
        		
        		if(var >= 10){
        			var -= 10;
        			last = 1;
        		}else{
        			last = 0;
        		}
        		
        		if(now == null){
        			now = new ListNode(var);
        			result = now;
        		}else{
        			ListNode next = new ListNode(var);
        			now.next = next;
        			now = next;
        		}
        		
        		l1 = l1==null?null:l1.next;
        		l2 = l2==null?null:l2.next;
        }
		
        return result;
    }
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		
		new Solution().addTwoNumbers(a1, b1);
	}
	 
}
