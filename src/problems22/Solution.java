package problems22;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月7日 下午4:27:39
 */



/*
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
public class Solution {
	/*
	 * 基本思路:
	 * 1.列出所有可能
	 * 2.排除有问题的可能
	 * 3.这个方法应该是O2，很笨
	 * 
	 * 
	 * 基本思路2:
	 * 1.递归方式
	 * 2,(代表1,)代表-1，控制当前的值大于等于0即可
	 * ps:string的构建耗费了过多时间，换成stringbuffer或者char[]可能会快一些
	 */
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n <= 0){
        		return result;
        }
        String now = "";
        generater(n, n, 0, now, result);
        return result;
    }
	
	public void generater(int pre ,int suf,int status,String now,List<String> result){
		
		//最后一个的时候
		if(pre == 0 && suf == 1){
			result.add(now + ")");
			return;
		}
		
		//其他时候
		if(status > 0){
			if(pre > 0){
				generater(pre-1, suf , status+1,now+"(",result);
				generater(pre , suf-1, status-1,now+")",result);
			}else{
				generater(pre, suf-1, status-1,now+")",result);
			}
		}else{
			generater(pre -1 , suf , 1,now+"(",result);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().generateParenthesis(0));
	}
}
