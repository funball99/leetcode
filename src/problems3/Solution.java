package problems3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月20日 上午10:10:49
 */


/*
 * 
My Submissions QuestionEditorial Solution
Total Accepted: 150323 Total Submissions: 678850 Difficulty: Medium
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class Solution {
	
	/*
	 * 基本思路:
	 * 1.分成字节数组
	 * 2.取下一个字符与已有字符对比
	 * 3.如果没重复，再取一个，如果有重复，计算当前的长度，并逐一清理队列头部的元素，直到队列不包含当前元素
	 * 4.重复步骤2直到结束
	 * 
	 * ps:这里可以用DP算法嘛?
	 */
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0 ){
        		return 0;
        }
        char[] array = s.toCharArray();
        List<String> leftSide = new ArrayList<String>();
        int max = 0;
        
        for(char x:array){
        		if(leftSide.contains(String.valueOf(x))){
        			max = max > leftSide.size()?max:leftSide.size();
        			while(leftSide.size() != 0){
        				leftSide.remove(0);
        				if(!leftSide.contains(String.valueOf(x))){
        					break;
        				}
        			}
        		}
        		leftSide.add(String.valueOf(x));
        }
        
		return max > leftSide.size()?max:leftSide.size();
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
		
	}
	
}
