package problems10;


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
	 * 来硬的咯
	 */
	public boolean isMatch(String s, String p) {
		
		char[] pattern = p.toCharArray();
		
		char[] input = s.toCharArray();
		
		for(int i = pattern.length - 1 ; i >= 0 ; i --){
			char c_pattern = pattern[i];
			
			
			
		}
		
        return false;
    }
}
