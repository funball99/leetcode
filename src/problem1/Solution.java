package problem1;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月19日 下午6:06:28
 */


/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/
public class Solution {
	/*
	 * 基本思路:
	 * 1.遍历nums
	 * 2.取第一个
	 * 3.取第二个
	 * 4.加，如果不符合，第二个数向后取
	 * 5.到最后，如果没有合格的第二个target，换第一个target
	 * 
	 * 
	 */
	public int[] twoSum(int[] nums, int target) {
        
		int[] result = new int[2];
		
		for(int i = 0 ; i < nums.length ; i ++){
			
			int x = nums[i];
			
			for(int j = i+1 ; j < nums.length ; j ++){
				int y = nums[j];
				
				if(x + y == target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
    }
	
}
