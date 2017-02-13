package problems31;


/*
 * 
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class Solution {
	
	/*
     * 基本思路:
     * 1.右向左遍历，找到第一个右>左的nums[x]
     * 2.右向左遍历，找到刚好比nums[x]大的nums[y]
     * 3.交换nums[x],nums[y]
     * 4.将x右侧排列的asc
     */
    public void nextPermutation(int[] nums) {
        
    		if(nums == null || nums.length <= 1){
    			return;
    		}
    	
    		int pre = 0;
    		int x = 0;
    		boolean find = false;
    		//1.右向左遍历，找到第一个右>左的nums[x]
    		for(int i = nums.length-1 ; i >= 0 ; i--){
    			int now = nums[i];
    			if(pre > now){
    				x = i;
    				find =true;
    				break;
    			}else{
    				pre = now;
    			}
    		}
    		
    		int x_val = nums[x];
    		int y = 0 ;
    		//2.右向左遍历，找到刚好比nums[x]大的nums[y]
    		if(find){
    			for(int i = nums.length-1 ; i > x ; i--){
        			int now_val = nums[i];
        			if(now_val > x_val){
        				y = i;
        				break;
        			}
        		}
    		}
    		
    		
    		//3.交换nums[x],nums[y]
    		int tmp = x_val;
    		nums[x] = nums[y];
    		nums[y] = tmp;
    		
    		//4.将x右侧排列的asc
    		if(!find) x--;
    		for(int i = 1 ; i <= (nums.length-x-1)/2 ; i ++){
    			int tmp_swap = nums[x+i];
    			nums[x+i] = nums[nums.length-i];
    			nums[nums.length-i] = tmp_swap;
    		}
    }
    
    public static void main(String[] args) {
		int [] nums = {1,2,3};
		new Solution().nextPermutation(nums);
		for(int x : nums){
			System.out.println(x);
		}
	}
}