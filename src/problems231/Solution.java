package problems231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0 ){
    		return false;
    	}
    	
    	
    	//solution 1    272ms
    	//λ���� & ͬΪ1��ʱ����Ϊ1������Ϊ0; &1��������ȡ���һλ����ֵ
    	//λ��������  >>(�޷���) �൱�ڳ���2 
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