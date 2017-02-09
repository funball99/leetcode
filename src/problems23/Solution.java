package problems23;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月7日 下午4:52:01
 */


/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class Solution {
	
	
	public static void main(String[] args) {
		int[] sort0 = new int[] { 1, 0, 10, 20 };
		int[] sort1 = new int[] { 9, 8, 12, 17, 34, 11};
		int[] sort2 = new int[] {3, 5, 6, 4};
		
		ListNode[] k = new ListNode[3];
		k[0]=toListNode(sort0);
		k[1]=toListNode(sort1);
		k[2]=toListNode(sort2);
		
		printNode(mergeKLists(k));
	}
	
	public static void printNode(ListNode input){
		while(input != null){
			System.out.print(input.val + ",");
			input = input.next;
		}
	}
	
	public static int[] toIntArray(ListNode node){
		List<Integer> result = new ArrayList<Integer>();
		while(node != null){
			result.add(node.val);
			node = node.next;
		}
		
		int[] r = new int[result.size()];
		for(int i = 0 ; i < result.size() ; i++){
			r[i] = result.get(i);
		}
		return r;
	}
	
	public static ListNode toListNode(int[] input){
		ListNode result = null;
		ListNode now = null;
		
		for(int i : input){
			
			if(result == null){
				result = new ListNode(i);
				now = result;
				continue;
			}
			
			now.next = new ListNode(i);
			now = now.next;
		}
		
		return result;
	}
	
	/*
	 * 基本思路:
	 * 1.list连起来
	 * 2.洗成大根堆
	 * 3.大根堆排序
	 * 4.输出
	 */
	
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode result = null;
		
		if(lists.length == 0){
			return result;
		}
		
		//1.list连起来
		ListNode tail = null;
		for(ListNode list : lists){
			if(list == null){
		        continue;
		    }
			if(result == null){
				result = list;
				tail = result;
				while(tail.next != null){
					tail = tail.next;
				}
				continue;
			}
			tail.next = list;
			while(tail.next != null){
				tail = tail.next;
			}
		}
		
		// 2.洗成大根堆
		int[] data = toIntArray(result);
		for(int i = (data.length-2)/2 ; i >= 0 ; i --){
			adjustDownToUp(data,data.length,i);
		}
		
		// 3.大根堆排序
		for(int i = data.length-1; i >= 1 ; i --){
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			adjustDownToUp(data,i,0);
		}
		
		 //4.输出
		return toListNode(data);
    }
	
	public static void adjustDownToUp(int[] data,int size,int index){
		
		int left = index*2 +1;
		int right = index*2 +2;
		
		int largest = index;
		
		if(left < size && data[left] > data[largest]){
			largest = left;
		}
		
		if(right < size && data[right] > data[largest]){
			largest = right;
		}
		
		if(largest != index){
			int tmp = data[largest];
			data[largest] = data[index];
			data[index] = tmp;
			adjustDownToUp(data,size,largest);
		}
		
	}
	
	public class HeapNode{
		int val;
		HeapNode left;
		HeapNode right;
	}
}
