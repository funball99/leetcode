package problems14;

import java.util.Arrays;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月30日 下午5:05:04
 */


/*
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
	/*
	 * 基本思路:懒得写了
	 */
	public String longestCommonPrefix(String[] strs) {
        char[] result = null;
		if(strs.length > 0){
			result = strs[0].toCharArray();
		}else{
			return "";
		}
		
		for(int i = 1 ; i < strs.length ; i ++){
			result = findPosition(result,strs[i]);
		}
		
		return (new String(result)).trim();
    }
	
	
	public char[] findPosition(char[] origin,String s){
		char [] input = s.toCharArray();
		int input_length = input.length;
		int origin_length = origin.length;
		
		
		for(int i = 0 ; i < origin.length ; i ++){
			
			if(i<= input_length-1 && i<= origin_length-1 && origin[i] == input[i]){
				continue;
			}else{
				return Arrays.copyOf(origin, i);
			}
			
		}
		
		
		return origin;
	}
}
