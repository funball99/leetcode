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
	 * 于是写着写着，写出来一坨。。。。
	 * sb透了。。看了别人写的，简直就不是一个级别的。。妈蛋，重新写。。
	 * 
	 */
	public boolean isMatch(String s, String p) {
		
		char[] pattern_array = p.toCharArray();
		
		char[] input_array = s.toCharArray();
		
		
		int input_index = 0;
		
		int input_length = input_array.length;
		int patter_array_length = pattern_array.length;
		
		for(int i = 0 ; i < patter_array_length; i ++){
			
			char pattern = pattern_array[i];
			
			if(pattern == '*'){
				
				char last_pattern = pattern_array[i-1];
				
				if(last_pattern == '.'){
					//.* 情况
					if(i + 1 == patter_array_length){
						return true;
					}else{
						//去掉.*直接匹配
						if(isMatch(new String(Arrays.copyOfRange(input_array,input_index, input_length)),new String(Arrays.copyOfRange(pattern_array,i+1, patter_array_length))) ){
							return true;
						}
						
						
						//挨个匹配
						while(input_index+1 < input_length){
							input_index++;
							if(isMatch(new String(Arrays.copyOfRange(input_array,input_index, input_length)),new String(Arrays.copyOfRange(pattern_array,i-1, patter_array_length))) ){
								return true;
							}
						}
						return false;
					}
					
				}else{
					//a*情况
					if(i + 1 == patter_array_length){
						
						char[] tmp = new char [input_length-input_index];
						Arrays.fill( tmp, last_pattern);
						return 	new String(tmp).equals(new String(Arrays.copyOfRange(input_array,input_index, input_length)));
						
					}else{
						//去掉a*直接匹配
						if(isMatch(new String(Arrays.copyOfRange(input_array,input_index, input_length)),new String(Arrays.copyOfRange(pattern_array,i+1, patter_array_length))) ){
							return true;
						}
						
						//挨个匹配
						while(input_index+1 < input_length){
							if(input_array[input_index] != last_pattern){
								break;
							}
							input_index++;
							if(isMatch(new String(Arrays.copyOfRange(input_array,input_index, input_length)),new String(Arrays.copyOfRange(pattern_array,i-1, patter_array_length))) ){
								return true;
							}
						}
						return false;
					}
				}
				
				
			}else if(pattern == '.'){
				
				if(i+1 < patter_array_length && pattern_array[i+1] == '*'){
					//.*情况
					continue;
				}else{
					//a.b情况
					input_index++;
					if(input_index == input_length){
						return isMatch("", new String(Arrays.copyOfRange(pattern_array,i+1, patter_array_length)));
					}else if(input_index > input_length){
						return false;
					}
					continue;
				}
				
			}else{
				//adsagwar情况
				if(input_index < input_length && pattern == input_array[input_index]){
					if(i+1<patter_array_length && pattern_array[i+1] == '*'){
						
					}else{
						input_index ++;
					}
					continue;
				}else{
					if(i+1<patter_array_length && pattern_array[i+1] == '*'){
						i++;
						continue;
					}else{
						return false;
					}
				}
			}
			
		}
		
		if(input_index < input_length){
			return false;
		}else{
			return true;
		}
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().isMatch("aa","a") == false);
		System.out.println(new Solution().isMatch("aa","aa") == true);
		System.out.println(new Solution().isMatch("aaa","aa") == false);
		System.out.println(new Solution().isMatch("aa", "a*")  == true);
		System.out.println(new Solution().isMatch("aa", ".*") == true);
		System.out.println(new Solution().isMatch("ab", ".*")  == true);
		System.out.println(new Solution().isMatch("aab", "c*a*b") == true);
		System.out.println(new Solution().isMatch("a", ".*..a*") == false);
		
		System.out.println(new Solution().isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c") == false);
		
		
	}
}
