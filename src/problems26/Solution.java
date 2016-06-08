package problems26;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月8日 下午6:19:17
 */

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
	
	
	/*
	 * 基本思路:
	 * 遍历
	 * 遇到相同的
	 * 继续
	 * 直到遇到不同的
	 * 赋值
	 */
	public int removeDuplicates(int[] nums) {
		
		int length = 1;
		for(int i = 1 ; i < nums.length ; i ++){
			
			if(nums[i] == nums[i-1]){
				
				continue;
				
			}else{
				nums[length++] = nums[i];
			}
		}
		return length;
    }
}
