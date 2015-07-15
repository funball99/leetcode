package problems233;

public class Solution1 {
	
	public int countDigitOne(int n) {
		if(n <= 0 ){
			return 0;
		}
		
        if(n == 1){
        	return 1;
        }
        
        int result = 0;
        int origin = n;
        
        while(origin != 0){
        	n = origin;
        	
        	while(n != 0){
            	if(n % 10 == 1){
            		result += 1;
            		break;
            	}else{
            		n = n /10;
            	}
            }
        	origin -= 1;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		
		System.out.println(new Solution1().countDigitOne(65535));
	}
	
}
