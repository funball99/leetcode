package problems9;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月27日 下午3:45:46
 */

/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
	public boolean isPalindrome(int x) {
		String ori = x+"";
		if(x < 0){
			return false;
		}else if(x == 0){
			return true;
		}
		
		String y = "";
		while(x != 0){
			y += (x % 10) + "";
			x = x / 10;
		}
		
		if(y.equals(ori)){
			return true;
		}else{
			return false;
		}
		
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(11));
	}
}
