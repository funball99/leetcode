package problems21;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月3日 下午2:58:51
 */

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode result = l1;
		 
		 if(l1 == null&&l2== null){
			 result = null;
		 }else if(l1 == null){
			 result = l2;
			 l2 = l2.next;
		 }else if(l2 == null){
			 result = l1;
			 l1 = l1.next;
		 }else if(l1.val > l2.val){
			 result = l2;
			 l2 = l2.next;
		 }else{
			 result = l1;
			 l1 = l1.next;
		 }
		 
		 ListNode it = result;
		 
		 while(l1 != null || l2 != null){
			 
			 if(l1 == null){
				 
				 it.next = l2;
				 it = it.next;
				 l2 = l2.next;
				 continue;
				 
			 }else if(l2 == null){
				 
				 it.next = l1;
				 it = it.next;
				 l1 = l1.next;
				 continue;
				 
			 }else{
				 if(l1.val > l2.val){
					 
					 it.next = l2;
					 it = it.next;
					 l2 = l2.next;
					 continue;
					 
				 }else{
					 
					 it.next = l1;
					 it = it.next;
					 l1 = l1.next;
					 continue;
					 
				 }
			 }
		 }
		 
		 return result;
     }
	 
	 
	 public static void main(String[] args) {
		 ListNode l1 = new ListNode(0);
		 ListNode l2 = null;
		new Solution().mergeTwoLists(l1, l2);
		
	}
	 
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
}
