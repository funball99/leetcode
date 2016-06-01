package problems19;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月1日 下午4:37:27
 */


/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

 */
public class Solution {
	public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
	
	/*
	 * 基本思路：懒得写。。。
	 * 
	 * 第二种思路貌似更快一点:
	 * 1.head.next ，计数，直到n = now;
	 * 2.如果next还有，就记录一个target = head,随着计数器++, target=target.next
	 * 3.next没有的时候，这时候target就是要处理的东西啦target.next = target.next.next;
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode end = head;
		
		int length = 1;
		
		while(end.next != null){
			length ++;
			end = end.next;
		}
		
		
		int target = length - n ;
		
		if(target == 0){
			return head.next;
		}
		
		ListNode now = head ;
		int now_index = 1;
		while(now_index != target){
			now_index ++;
			now = now.next;
		}
		now.next = now.next.next;
			
		return head;
    }
}
