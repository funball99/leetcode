package problems27;

import java.util.Arrays;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月8日 下午6:01:09
 */


/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 */

public class Solution {
	/*
	 * 基本思路:
	 * 不说了。。。简直so easy!
	 */
	public int removeElement(int[] nums, int val) {
        
		int length = 0;
		
		for(int i = 0 ; i < nums.length ; i ++){
			if(nums[i]  == val){
				continue;
			}else{
				nums[length++] = nums[i];
			}
		}
		
		
		nums = Arrays.copyOf(nums, length);
		return nums.length;
    }
}
