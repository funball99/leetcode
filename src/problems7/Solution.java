package problems7;



/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月25日 下午5:31:58
 */


/*
 
 Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

 * 
 */
public class Solution {
	
	/*
	 * 基本思路：
	 * 1.转成字符串
	 * 2.倒序
	 * 3.转成数字
	 * 
	 */
	public int reverse(int x) {
		try{
			boolean negtive = x < 0?true:false;
			
			if(negtive){
				x = x * (-1);
			}
			
			String s = "" + x;
			
			char[] array = s.toCharArray();
			
			int i = 0;
			int length = array.length;
			
			while(i < length-1-i){
				char tmp = array[i];
				array[i]= array[length-1-i];
				array[length-1-i] = tmp;
				i++;
			}
			
			x = Integer.parseInt(new String(array));
			if(negtive){
				x = x * (-1);
			}
			
	        return x;
		}catch(Exception e){
			return 0;
		}
		
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverse(1534236469));
	}
}
