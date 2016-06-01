package problems18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月1日 上午11:51:18
 */

/*
 * 
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    
 */



public class Solution {

	
	/*
	 * 基本思路:
	 *  1:
	 * * * * * * * * * * * * * * * * * * * *
	 * x 1    							 2 x
	 * x 1 	   						   2   x
	 * x 1 		   					2      x
	 * 
	 * 
	 * 2:
	 * * * * * * * * * * * * * * * * * * * * *
	 * x 1 2 3  							
	 * x 1 2	   3						   
	 * x 1 2		 3  					
	 * 
	 * 以下实现的是第二种方法，超时了。
	 * 
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length < 4){
			return result;
		}
		Arrays.sort(nums);
		
		
		int x = 0;
		int y = 1;
		int z = 2;
		int iterator = 3;
		
		while(z < nums.length-1){
			
			int sum = nums[x] + nums[y] + nums[z] + nums[iterator];
			
			
			//这个while里面可以二分法来优化
			while(sum < target){
				iterator ++;
				if(iterator > nums.length-1){
					iterator--;
					break;
				}
				sum = nums[x] + nums[y] + nums[z] + nums[iterator];
			}
			
			if(sum == target){
				
				//一组答案
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(nums[x]);
				tmp.add(nums[y]);
				tmp.add(nums[z]);
				tmp.add(nums[iterator]);
				result.add(tmp);
				
			}
			
			//下一组
			int tmp = 0;
			
			if(z == nums.length - 2 && z-y ==1 && y-x == 1){
				break;
			}
			
			while(true){
				if(z < nums.length-2){
					tmp = nums[z];
					z ++;
					if(tmp == nums[z]){
						continue;
					}else{
						break;
					}
				}else if(y < nums.length-3){
					
					tmp = nums[y];
					y ++;
					if(tmp == nums[y]){
						continue;
					}else{
						z = y + 1;
						break;
					}
					
				}else if(x < nums.length -4){
					
					tmp = nums[x];
					x ++;
					if(tmp == nums[x]){
						continue;
					}else{
						y = x + 1;
						z = y + 1;
						break;
					}
				}else{
					break;
				}
			}
			iterator = z + 1;
			//这里有个优化方案，因为iterator是记录的，而且数组有序，所以iterator再sum>target的时候，不必重置，因为新的iterator值一定在现在值的左侧附近
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int [] nums = {1,0,-1,0,-2,2};
		System.out.println(new Solution().fourSum(nums, 0));
	}
	
}
