package problems13;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月30日 下午4:12:12
 */



/*
 * 
 * 
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * 
 */


/*
 * 罗马数字体系大约发明于公元前７５０年，
 * 如下符号：Ｉ、Ｖ、Ｘ、  Ｌ、   Ｃ、    Ｄ   和Ｍ，
 * 分别表示 １、５、１０、５０、１００、５００和１０００；
 * 为了表示更大的数，人们在这些符号上方划一横道表示乘１０００，
 * 划两横道表示乘两次１０００；罗马数字没有零，运算的时候不能进位，不能做除法，即使十分简单的运算，也极为困难。
 */

public class Solution {
	public int romanToInt(String s) {
        int result = 0;
		char[] array = s.toCharArray();
		
		for(int i = 0 ; i < array.length ; i ++){
			
			char x = array[i];
			
			switch (x) {
			case 'M':
				if((i-1)>=0 && array[i-1]=='C'){
					result += 800;
				}else{
					result += 1000;
				}
				break;
			case 'D':
				if((i-1)>=0 && array[i-1]=='C'){
					result += 300;
				}else{
					result += 500;
				}
				break;
			case 'C':
				if((i-1)>=0 && array[i-1]=='X'){
					result += 80;
				}else{
					result += 100;
				}
				break;
			case 'L':
				if((i-1)>=0 && array[i-1]=='X'){
					result += 30;
				}else{
					result += 50;
				}
				break;
			case 'X':
				if((i-1)>=0 && array[i-1]=='I'){
					result += 8;
				}else{
					result += 10;
				}
				break;
			case 'V':
				if((i-1)>=0 && array[i-1]=='I'){
					result += 3;
				}else{
					result += 5;
				}
				break;
			case 'I':
				result += 1;
				break;
			}
		}
		
		return result;
    }
}
