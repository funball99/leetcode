package problems8;



/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月27日 下午3:10:14
 */


/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution{
	
	/*
	 * 基本思路：
	 * 懒得说了，解释下题目的意思：取非空字符，组成数字，遇到invalid的就结束
	 */
	public int myAtoi(String str) {
		str = str.trim();
		char[] input = str.toCharArray();
		char[] result = new char[input.length];
		int index_result = 0;
		
		char signal = '0';
		
		for(int i = 0 ; i < input.length ; i ++){
			char x = input[i];
			int x_int = (int)x;
			
			if(x_int >=48 && x_int <= 57){
				result[index_result++] = x;
			}else if(signal=='0' && (x_int == 45 || x_int == 43)){
				signal = x;
			}else{
				break;
			}
		}
		
		String str_result = new String(result);
		str_result = str_result.trim();
		
		if(str_result.length() == 0){
			return 0;
		}
		
		if((int)signal == 45){
			str_result = "-" + str_result;
		}
		
		try{
			return Integer.parseInt(str_result);
		}catch(Exception e){
			if((int)signal == 45){
				return Integer.MIN_VALUE;
			}else{
				return Integer.MAX_VALUE;
			}
			
		}
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().myAtoi("23a8f"));
	}
	
}
