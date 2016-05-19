package problems221;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月19日 下午4:55:30
 * 
 * 
 * 
 */

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
*/


//动态规划问题，有好多其他的DP解法，比我的快很多....这个方法明显的强行解，没有任何数学逻辑。。。beat 不到1%

public class Solution {
	public int maximalSquare(char[][] matrix) {
		
		int maxArea = 0;

		if(matrix.length == 0){
			return maxArea;
		}
		
		int width = matrix[0].length;
		int height = matrix.length;
		
		
		for(int i = 0 ; i < height ; i ++){
			
			for(int j = 0 ; j < width; j ++){
				
				//如果左上角坐标为(0,0)，现在坐标为(i,j) (ps:先纵坐标)
				
				//当前坐标为基点，最大面积为tempArea
				int tempArea = 0;
				
				char now = matrix[i][j];
				
				if(now == '0'){
					continue;
				}else{
					//本点
					tempArea = 1;
					if(tempArea > maxArea){
						maxArea = tempArea;
					}
					
					//a*a
					int a = Math.min(width-j, height-i);
					for(int temp = 1 ; temp <  a; temp ++){
						
						boolean breakFor = false;
						
						for(int x = 0 ; x <= temp ; x ++){
							for(int y = 0 ; y <= temp ; y ++){
								if(matrix[i+x][j+y] == '0' ){
									breakFor = true;
									break;
								}
							}
							if(breakFor){
								break;
							}
						}
						if(!breakFor){
							tempArea = (int)Math.pow(temp+1, 2);
							if(tempArea > maxArea){
								maxArea = tempArea;
							}
						}
					}
				}
			}
		}
		return maxArea;
    }
	
	public static void main(String[] args) {
		char[][] x = {{'1','0'},{'1','0'}};
		
		System.out.println(new Solution().maximalSquare(x));
		
	}
}
