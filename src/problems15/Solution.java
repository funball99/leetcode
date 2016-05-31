package problems15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月30日 下午5:48:19
 */

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */


public class Solution {
	/*
	 * 基本思路:
	 * 1.排序
	 * 2.第一个数字ai,后面的用两头逼近的方式，找到对应的多组
	 * 3.i++
	 * 4.注意相同数字的判断 
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length < 3){
			return result;
		}
		int total_lenght = nums.length -1;
		Arrays.sort(nums);
		
		for(int i = 0 ; i < nums.length ; i ++){
			if(i-1>=0 && nums[i] == nums[i-1]){
				continue;
			}
			List<Integer> tmpList = new ArrayList<Integer>();
			
			int left = i + 1;
			int right = total_lenght;
			
			while(left < right ){
				int left_val = nums[left];
				int right_val = nums[right];
				int sum = nums[i] + left_val + right_val;
				
				if(sum == 0){
					tmpList.add(nums[i]);
					tmpList.add(nums[left]);
					tmpList.add(nums[right]);
					result.add(tmpList);
					tmpList = new ArrayList<Integer>();
					
					left++;
					right--;
					while(left<=total_lenght && nums[left] == left_val){
						left++;
					}
					while(right>=0 && nums[right] == right_val){
						right--;
					}
					
				}else if(sum > 0){
					while(right>=0 && nums[right] == right_val){
						right--;
					}
					
				}else if(sum < 0){
					while(left<=total_lenght && nums[left] == left_val){
						left++;
					}
				}
			}
			
		}
		return result;
    }
	
	
	public static void main(String[] args) {
		 int []input = {0,0,0,0};
		System.out.println(new Solution().threeSum(input));
	}
}
