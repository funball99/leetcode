package problems25;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class Solution {
	
	/*
	 * 
	 * 这个是对应solution里面的方法
	 * 
	 * 基本思路:
	 * 1.分段(第一段和其他)
	 * 2.后面的，用本函数进行迭代
	 * 3.本段进行反转
	 * 
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode curr = head;
		int count = 0;
		
		//找k+1的节点
		while(curr != null && count != k){
			curr = curr.next;
			count ++;
		}
		
		if(k == count){
			//后面的，用本函数进行迭代
			curr = reverseKGroup(curr,k);
			
			while(count-- > 0){
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			head = curr;
		}
		
		return head;
	}
}
