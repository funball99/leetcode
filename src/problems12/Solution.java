package problems12;



/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月27日 下午4:47:57
 */


/*
 * 
 * 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 * 
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
	
	
	/*
	 * 基本思路:
	 * 1.列出来分别计算的结果
	 * 2.抽象出来循环的结果
	 * 3.我是不是有点low?
	 */
	public String intToRomanOriginal(int num) {
        String result = "";
        int tmp;
        
        tmp = num / 1000;
		if(tmp > 0){
        		for(int i = 0 ; i < tmp ; i ++){
        			result += "M";
        		}
        		num = num % 1000;
        }
		
		
		tmp = num / 100;
		if(tmp > 0){
			if(tmp == 9){
				result += "CM";
			}else if(tmp >= 5){
				result += "D";
				tmp -= 5;
			}
			for(int i = 0 ; i < tmp ; i ++){
				result += "C";
			}
			
	    		num = num % 500;
	    }
		
		tmp = num / 10;
		if(tmp > 0){
	    		if(tmp == 9){
	    			result += "XC";
	    		}else if(tmp >= 5){
	    			result += "L";
				tmp -= 5;
	    		}
	    		for(int i = 0 ; i < tmp ; i ++){
				result += "X";
			}
	    		num = num % 10;
	    }
		
		tmp = num;
		if(tmp > 0){
	    		if(tmp == 9){
	    			result += "IX";
	    		}else if(tmp >= 5){
	    			result += "V";
				tmp -= 5;
	    		}
	    		for(int i = 0 ; i < tmp ; i ++){
				result += "I";
			}
	    }
	    		
		return result;
    }
	
	public String intToRoman(int num) {
        String result = "";
        
        String [] nine = {"MW","CM","XC","IX"};
        String [] five = {"5M","D","L","V"};
        String [] four = {"4M","CD","XL","IV"};
        String [] one = {"M","C","X","I"};
        
        int x = 1000;
        int tmp = 0;
        
        for(int it = 0 ; ; it ++){
        		tmp = num / x;
	    		if(tmp > 0){
	    			if(tmp == 9){
	    				result += nine[it];
	    				tmp -= 9;
	    			}else if(tmp >= 5){
	    				result += five[it];
	    				tmp -= 5;
	    			}else if(tmp == 4){
	    				result += four[it];
	    				tmp -= 4;
	    			}
	    			for(int i = 0 ; i < tmp ; i ++){
	    				result += one[it];
	    			}
	    			
	    	    		num = num % x;
	    	    }
	    		x /= 10;
    			if(num*x == 0){
    				break;
    			}
	    		tmp = num / x;
        }
        
	    		
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(4));
	}
}
