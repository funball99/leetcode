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
		if(x < 0 ){
			return false;
		}
		
		x = x >> 1;
		if(x >= 0 && x <= 9){
			return true;
		}else{
			return isPalindrome(x);
		}
    }
	
	public static void main(String[] args) {
		System.out.println(3&1);
	}
}
