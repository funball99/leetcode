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
public class Solution2 {
	
	/*
	 * 基本思路：
	 * 以第二个字符为准...
	 * 
	 * 
	 */
	public boolean isMatch(String s, String p) {
		
		if(p.length() == 0){
			return s.length() == 0;
		}
		
		
		
		if(p.length() > 1 && p.charAt(1) == '*'){ //第二个是*
			
			if(isMatch(s, p.substring(2))){
				//x*不匹配东西
				return true;
			}
			
			//去匹配
			if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
				return isMatch(s.substring(1), p);
			}
			
			return false;
			
		}else{ //第二个不是*
			
			if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
				return isMatch(s.substring(1), p.substring(1));
			}
			
			return false;
			
		}
		
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution2().isMatch("aa","a") == false);
		System.out.println(new Solution2().isMatch("aa","aa") == true);
		System.out.println(new Solution2().isMatch("aaa","aa") == false);
		System.out.println(new Solution2().isMatch("aa", "a*")  == true);
		System.out.println(new Solution2().isMatch("aa", ".*") == true);
		System.out.println(new Solution2().isMatch("ab", ".*")  == true);
		System.out.println(new Solution2().isMatch("aab", "c*a*b") == true);
		System.out.println(new Solution2().isMatch("a", ".*..a*") == false);
		
		System.out.println(new Solution2().isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c") == false);
		
		
	}
}
