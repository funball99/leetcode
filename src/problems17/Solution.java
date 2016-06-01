package problems17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月31日 下午6:04:04
 */



/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {

	
	
	/*
	 * 基本思路:
	 * 1.如果是1位数，则  : a,b,c
	 * 2,如果是两位数,在以为数的基础上，将输出序列扩展n倍(n为第二位数包含的字母数),然后每个数后面循环加入第二位数代表的字母
	 * 
	 * : a,b,c  *  d,e,f
	 * 
	 * =>
	 *  a,b,c,a,b,c,a,b,c
	 *  ad,bd,cd,|||  ae,be,ce, ||| af,bf,cf
	 *  
	 * 3,依此类推
	 * 
	 * 
	 * 
	 * ps:如果用递归的思路会更快
	 */
	public List<String> letterCombinations(String digits) {
		List<String > result = new ArrayList<String>();
		
		char[] array = digits.toCharArray();
		
		
		
		for(char x : array){
			
			char [] tmpArray = getData((int)x);
			
			if(result.size() == 0){
				
				for(char tmp : tmpArray){
					result.add(String.valueOf(tmp));
				}
				
			}else{
				
				List<String> base = new ArrayList<String>();
				base.addAll(result);
				
				for(int i = 0 ; i < tmpArray.length -1 ; i ++){
					result.addAll(base);
				}
				
				int per = base.size();
				
				for(int i = 0 ; i < result.size() ; i ++){
					
					String t = result.get(i);
					t += tmpArray[(i / per)];
					result.set(i, t);
				}
				
			}
			
		}
		
		
		return result;
    }
	
	public char[] getData(int key){
		
		Map<Integer,char[]> data = new HashMap<Integer,char[]>();
		
		char[] one = {};
		char[] two = {'a','b','c'};
		char[] three = {'d','e','f'};
		char[] four = {'g','h','i'};
		char[] five = {'j','k','l'};
		char[] six = {'m','n','o'};
		char[] seven = {'p','q','r','s'};
		char[] eight = {'t','u','v'};
		char[] nine = {'w','x','y','z'};
		
		data.put((int)'1', one);
		data.put((int)'2', two);
		data.put((int)'3', three);
		data.put((int)'4', four);
		data.put((int)'5', five);
		data.put((int)'6', six);
		data.put((int)'7', seven);
		data.put((int)'8', eight);
		data.put((int)'9', nine);
		
		return data.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("234"));
	}
	
}
