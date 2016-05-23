package problems6;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月23日 下午5:55:16
 */

/*
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 */
public class Solution {
	/*
	 * 基本思路:
	 * 反正就是横向根据规则去取数字，只循环一个就好，GOOD！
	 */
    public String convert(String s, int numRows) {
    		
    		if(s==null || numRows == 1 || s.length() <= 1){
    			return s;
    		}
    	
    		char[] input = s.toCharArray();
    		
    		int length = input.length;
    		
    		char[] output = new char[length];
    		
    		for(int i = 0 ; i < output.length ; i ++){
    			
    			
    			int turn = 0;
    			int pre = 0;
    			int now = 0;

    			
    			while(pre != numRows){
    				//第一个数字
    				now = turn * 2 * (numRows - 1) + pre;
    				if(now > length - 1){
    					turn = 0;
    					pre++;
    					continue;
    				}
    				output[i] = input[now];
    				i++;
    				
    				//第二个数字
    				if(pre % (numRows-1) != 0){
    					now = (turn+1) * 2 * (numRows-1) - pre;
    					if(now > length - 1){
        					turn = 0;
        					pre++;
        					continue;
        				}
        				output[i] = input[now];
    					i++;
    				}
    				
    				//下一个数字
    				turn ++;
    			}
    			
    		}
    		return new String(output);
    }
    
    public static void main(String[] args) {
    		System.out.println(new Solution().convert("AB", 2));
	}
}
