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
	 * 1.以第一个为中点，看最大回文
	 * 2.i++ ，循环直到最后一个
	 * 3.注意两个字符之间是有一个位置的!
	 */
	public String longestPalindrome(String s) {
		String longgest = "";
		
		
		boolean isHalf = false;
		for(int i = 0 ; i < s.length() ; ){
			
			String tmp = findPalindromic(s,i,isHalf);
			
			if(tmp.length() > longgest.length()){
				longgest = tmp;
			}
			
			if(isHalf){
				isHalf = false;
				i ++;
			}else{
				isHalf = true;
			}
			
		}
		return longgest;
		
    }
	
	public String findPalindromic(String s,int pos,boolean half){
		int i = 0;
		
		if(half){
			
			while(pos - i  >= 0 && pos + i + 1 < s.length()){
				if(s.charAt(pos - i) == s.charAt(pos + i + 1)){
					i ++;
				}else{
					break;
				}
			}
			
			i--;
			return s.substring(pos - i ,pos + i + 2);
			
		}else{
			while(pos - i  >= 0 && pos + i < s.length()){
				if(s.charAt(pos - i) == s.charAt(pos + i)){
					i ++;
				}else{
					break;
				}
			}
			
			i--;
			return s.substring(pos - i ,pos + i + 1);
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution2().longestPalindrome("ccs"));
	}
	
}
