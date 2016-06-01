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



public class Solution2 {

	
	/*
	 * 基本思路:
	 * * * * * * * * * * * * * * * * * * * 
	 * x x 1  							 2 
	 * x x 1	   						   2   
	 * x x 1		   					2      
	 * 
	 * 
	 * 
	 * so,有了3sum,4sum,what about nSum?
	 * 
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length < 4){
			return result;
		}
		Arrays.sort(nums);
		
		int x1_index = 0;
		int x2_index = 1;
		
		while(true){
			int x1 = nums[x1_index];
			int x2 = nums[x2_index];
			
			int left_index = x2_index + 1;
			int right_index = nums.length - 1;
			int left_val = nums[left_index];
			int right_val = nums[right_index];
			
			while(left_index < right_index){
				left_val = nums[left_index];
				right_val = nums[right_index];
				
				int sum = x1+ x2 + left_val + right_val;
				
				if(sum > target){
					int o = right_val;
					right_index--;
					while(right_index > left_index && o == nums[right_index]){
						right_index--;
					}
					
				}else if(sum < target){
					int o = left_val;
					left_index ++;
					while(right_index > left_index && o == nums[left_index]){
						left_index ++;
					}
					
				}else{
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(x1);
					tmp.add(x2);
					tmp.add(left_val);
					tmp.add(right_val);
					result.add(tmp);
					tmp = new ArrayList<Integer>();
					
					
					int o = right_val;
					right_index--;
					while(right_index > left_index && o == nums[right_index]){
						right_index--;
					}
					o = left_val;
					left_index ++;
					while(right_index > left_index && o == nums[left_index]){
						left_index ++;
					}
				}
				
				
			}
			
			if(x2_index == nums.length-3 && x1_index == x2_index - 1){
				break;
			}
			
			int tmp = 0;
			while(true){
				if(x2_index < nums.length-3){
					tmp = nums[x2_index];
					x2_index ++;
					if(tmp == nums[x2_index]){
						continue;
					}else{
						break;
					}
					
				}else if(x1_index < nums.length - 4){
					
					tmp = nums[x1_index];
					x1_index ++;
					if(tmp == nums[x1_index]){
						continue;
					}else{
						x2_index = x1_index + 1;
						break;
					}
					
				}else if(x2_index == nums.length-3 && x1_index == x2_index - 1){
					break;
				}
			}
			
		}
		
		return result;
    }
	
	
	public static void main(String[] args) {
//		int [] nums = {-5,-4,-2,-2,-2,-1,0,0,1};
//		System.out.println(new Solution2().fourSum(nums, -9));
		
		List<List<Integer>> a = new ArrayList<List<Integer>>();
		
		List<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(3);
		a1.add(5);
		
		List<Integer> b1 = new ArrayList<Integer>();
		b1.add(1);
		b1.add(3);
		b1.add(5);
		
		a.add(a1);
		System.out.println(a.contains(b1)); //true  可以用这个方法去重，会简洁一点，但是效率会低
		
		
	}
	
}
