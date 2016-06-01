package problems20;

import java.util.Stack;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月1日 下午5:04:08
 */


/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Solution {
	
	/*
	 * 基本思路：用stack
	 */
	public boolean isValid(String s) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		char[] array = s.toCharArray();
		
		try{
			for(char x : array){
				switch (x) {
				case '(':
					stack.push((int)x);
					break;
				case '{':
					stack.push((int)x);
					break;
				case '[':
					stack.push((int)x);
					break;
				case ')':
					if(stack.pop() != (int)'('){
						return false;
					}
					break;
				case '}':
					if(stack.pop() != (int)'{'){
						return false;
					}
					break;
				case ']':
					if(stack.pop() != (int)'['){
						return false;
					}
					break;
				}
			}
		    return stack.isEmpty();
		}catch(Exception e){
			return false;
		}
       
    }
}
