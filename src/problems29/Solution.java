package problems29;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月13日 上午10:57:30
 */


/*
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

 */


public class Solution {
	/*
	 * 基本思路:
	 * 不让用乘除以及mod,那就加嘛(超时了。我日)
	 * 
	 * 
	 * a / b  =? 
	 * 
	 * a > b ? 
	 * y => b += b 
	 * n => 递归
	 * 
	 * 最后得到一共加了多少个b（ps:这里的b是成倍增加的，所以比较快,b,2b,4b,8b....） 
	 * 
	 */
	public int divide(int dividend, int divisor) {
		int result = 0;
		int now = divisor;
		
		if(divisor == 0){
			return divisor;
		}else if(divisor == dividend){
			return 1;
		}else if(divisor == 1){
			return dividend;
		}else if(divisor == -1){
			
			if (dividend == Integer.MIN_VALUE){
				return Integer.MAX_VALUE;
			}else{
				return 0-dividend;
			}
		}
		
		boolean negtive = false;
		
		if((dividend < 0 && divisor > 0)||(dividend > 0 && divisor < 0)){
			negtive = true;
		}
		dividend = 0-dividend>0?dividend:0-dividend;
		divisor = 0-divisor>0?divisor:0-divisor;
		
        
		result = 1;
		now = divisor;
		
		if(divisor < dividend){
			return 0;
		}
		
        while(true){
        		
	        	if(now+now < dividend || now+now >=0){
        			break;
        		}
        		now += now;
    			result += result;
        }

        
        if(negtive){
        		return 0-(result+divide(dividend-now, divisor));
        }else{
        		return result+divide(dividend-now, divisor);
        }
	        
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().divide(-2147483648,1));
	}
}
