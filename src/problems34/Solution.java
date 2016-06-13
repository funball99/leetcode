package problems34;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月13日 下午4:45:20
 */

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */

public class Solution {
	
	/*
	 * 基本思路:
	 * 也还就是一个二分法嘛
	 */
	 public int[] searchRange(int[] nums, int target) {
		int length = nums.length;
 		
 		int left = 0;
 		
 		int right = length-1;
 			
 		
 		int now = (left + right)/2;
 		
 		
 		while(left < right){
 			
 			if(nums[now] < target){
 				left = now+1;
 			}else if(nums[now] > target){
 				right = now-1;
 			}else{
 				right = now;
 			}
 			now = (left + right)/2;
 			
 		}
 		
 		
 		int [] result = {-1,-1};
 		int [] t  = {-1,-1};
 		
 		if(target == nums[now]){
			result[0] = now;
			result[1] = now;
 		}
 		
 		for(; now < length  ; now++){
 			if(target == nums[now] ){
 				result[1] = now;
 	 		}
 		}
 		
 		if(result[0] == -1){
 			return t;
 		}
 		
 		return result;
    }
	 
	 public static void main(String[] args) {
		 int nums[] = {2,2};
		 int[] result = new Solution().searchRange(nums, 2);
		System.out.println(result[0] + " " + result[1]);
	}
	
}
