package problems11;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月27日 下午4:42:10
 */


/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

*/

public class Solution {
	/*
	 * 基本思路:
	 * 2.取b1，以b1为边组成的最大的面积，就是和b1距离最远的边组成的面积(因为b1是两边中的短边,面积=宽度*高度,高度=b1)
	 * 3.遍历bi，取得最大值
	 * 
	 * 
	 * 
	 */
	public int maxArea(int[] height) {
		int length = height.length;
		int maxArea = 0 ;
		
		for(int i = 0 ; i < length ; i ++){
			
			int x = i;
			int y = height[i];
			
			int left = 0;
			int right = length-1;
			
			int tmpMax = 0;
			
			//向左侧
			while(x > left){
				tmpMax = y*(x - left);
				if(tmpMax > maxArea){
					
					if(height[left] >= y){
						maxArea = tmpMax;
						break;
					}
					left++;
					
				}else{
					break;
				}
			}
			
			//向右侧
			while(right > x){
				tmpMax = y*(right -x );
				if(tmpMax > maxArea){
					if(height[right] >= y){
						maxArea = tmpMax;
						break;
					}
					right--;
				}else{
					break;
				}
			}
			
		}
		
		
        return maxArea;
    }
	
	public static void main(String[] args) {
//		int [] height = new int[150000];
//		for(int i = 0 ; i < 150000 ; i ++){
//			height[i] = i+1;
//		}
		int [] height = {2,2,2,1};
		Long a = System.currentTimeMillis();
		System.out.println(new Solution().maxArea(height));
		System.out.println(System.currentTimeMillis() - a);
	}
	
}
