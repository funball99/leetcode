package problems231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0 ){
    		return false;
    	}
    	
    	
    	//solution 1    272ms
    	//位运算 & 同为1的时候结果为1，否则为0; &1经常用来取最后一位的数值
    	//位运算右移  >>(无符号) 相当于除以2 
    	while(n != 1){
    		if((n & 1) == 1){
        		return false;
        	}
    		n = n >> 1;
    	}
    	
    	return true;
    	
    	//solution 2    276ms
    	//return (n & (n-1)) == 0;
    }
    
    
 
}