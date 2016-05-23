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

//很憨厚的解法。。。。嗯。。。很慢
public class Solution {
	
	/*
	 * 基本思路:
	 * 1.取第1个,计算以他开始的回文最大长度
	 * 	1.1 两头逼近的方式取得回文
	 * 2.循环步骤1 
	 */
	public String longestPalindrome(String s) {
		if(s == null || s == "" || s.length() == 1 || s.length() == 0){
			return s;
		}
		
		String longest = "";
		
		char[] array = s.toCharArray();
		
		for(int i = 0 ; i < array.length ; i  ++){
			int start = i;
			
			int innerEnd = array.length - 1;
			
			int tmpEnd = innerEnd;
			while(innerEnd > start){
				
				while(array[start] == array[innerEnd]){
					start++;
					innerEnd --;
					if(start >= innerEnd){
						break;
					}
				}
				if(start >= innerEnd){
					if(longest.length() < (start - innerEnd + 1))
					longest = s.substring(i,tmpEnd + 1);
					break;
				}else{
					tmpEnd --;
					innerEnd = tmpEnd;
					start = i;
				}
			}
			
		}
		return longest;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("ccs"));
	}
	
}
