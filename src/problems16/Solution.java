package problems16;

import java.util.Arrays;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月31日 下午2:32:10
 */

/*
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */


public class Solution {
	
	
	/*
	 * 基本思路:
	 * 1.sorted
	 * 2.两边逼近
	 */
    public int threeSumClosest(int[] nums, int target) {
    
    		int result = 0 ;
    		int min = -1;
    		
    		Arrays.sort(nums);
    		
    		for(int i = 0 ; i < nums.length ; i ++){
    			
    			int left = i + 1;
    			int right = nums.length-1;
    			
    			while(left < right){
    				
    				int left_val = nums[left];
    				int right_val = nums[right];
    				int sum = nums[i] + left_val + right_val;
    				
    				if(sum > target){
    					right--;
    				}else if (sum < target){
    					left++;
    				}else{
    					return sum;
    				}
    				
    				if(min < 0 || Math.abs(sum-target) < min){
    					min = Math.abs(sum-target);
    					result = sum;
    				}
    			}
    			
    		}
    		
    		return result;
    }
	
    public static void main(String[] args) {
    		int [] nums = {-10,-10,-8,-8,-8,-7,-7,-5,-4,-2,0,0,1,1,2,2,3,6,6,8};
    		
		System.out.println(new Solution().threeSumClosest(nums, 18));
	}
}
