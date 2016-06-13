package problems35;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月13日 下午4:07:18
 */


/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

public class Solution {
	/*
	 * 基本思路:
	 * ma~就一个二分法嘛
	 */
    public int searchInsert(int[] nums, int target) {
        
    		int length = nums.length;
    		
    		int left = 0;
    		
    		int right = length-1;
    		
    		
    		int now = (left + right)/2;
    		
    		
    		while(left < right){
    			
    			if(nums[now] < target){
    				
    				left = now+1;
    				now = (left + right)/2;
    				
    			}else if(nums[now] > target){
    				
    				right = now-1;
    				now = (left + right)/2;
    				
    			}else{
    				break;
    			}
    			
    		}
    		
    		if(target>nums[now]){
    			return now+1;
    		}else{
    			return now;
    		}
    		
    	
    }
    
    public static void main(String[] args) {
    		int[] nums = {3};
		System.out.println(new Solution().searchInsert(nums, 2));
	}
}
