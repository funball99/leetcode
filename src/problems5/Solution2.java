package problems5;

import java.util.Stack;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月20日 下午2:31:37
 */


/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

public class Solution2 {
	
	/*
	 * 基本思路:
	 * 
	 */
	public String longestPalindrome(String s) {
		String longest ="";
		int [] map = new int[128];
		char[] array = s.toCharArray();
		
		for(int i = 0 ; i < array.length ; i ++){
			char x  = array[i];
			
			if(map[x] > 0){
				
				
				
				
				
			}else{
				map[x] = i;
			}
			
		}
		
		
		return longest;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution2().longestPalindrome("ccs"));
	}
	
}
