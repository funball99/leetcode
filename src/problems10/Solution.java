package problems10;

import java.util.Arrays;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月27日 下午4:26:18
 */



/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

*/
public class Solution {
	
	/*
	 * 基本思路：
	 * 估计要递归了，不递归没法做了
	 */
	public boolean isMatch(String s, String p) {
		
		char[] pattern_array = p.toCharArray();
		
		char[] input_array = s.toCharArray();
		
		
		int input_index = 0;
		
		int patter_array_length = pattern_array.length;
		
		for(int i = 0 ; i < patter_array_length; i ++){
			
			char pattern = pattern_array[i];
			
			if(pattern == '*'){
				
				char last_pattern = pattern_array[i-1];
				char last_input = input_array[input_index - 1];
				
				if(last_pattern == '.'){
					//.* 情况
					
					
				}else{
					//a*情况
//					if(last_input)
					
				}
				
				
			}else if(pattern == '.'){
				//a.b情况
				input_index++;
				continue;
				
			}else{
				//adsagwar情况
				if(pattern == input_array[input_index]){
					input_index ++ ;
					continue;
				}else{
					return false;
				}
				
			}
			
		}
		
        return false;
    }
}
