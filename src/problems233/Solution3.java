package problems233;

public class Solution3 {
	
	public int countDigitOne(int n) {
		int result = 0;
		
		if(n <= 0){
			return 0;
		}
		
		if(n == 1){
			return n;
		}
		
		if(n < 10){
			return 1;
		}
		
		String nStr = String.valueOf(n);
		
		//the number one occurred times
		boolean isOne = false;
		int countOne = 0 ;
		
		for(int i = 0 ; i<nStr.length() ; i++){
			//int now = Integer.parseInt(String.valueOf(nStr.charAt(i)));
			int now = nStr.charAt(i)-48;
			int pos = nStr.length() - 1 - i;
			
			
			if(now == 0){

				//do nothing
				
				
			}else if (now == 1){
				
				if(pos >= 1){
					
					result = result + (int)(1 + (pos)*Math.pow(10, pos-1));
					
				}else{
					
					//if the last one is 1 ,do countOne one more time
					countOne += 1;
					
				}
				
				isOne = true;
				
			}else{
				
				if(pos >= 1){
					
					result = result + (int)(Math.pow(10, pos) + ((now)*pos)*Math.pow(10, pos-1));
					
				}else{
					
					result += 1;
					
				}
				
			}
			
			//fix if the upper position "one"
			result += (countOne ) * now * Math.pow(10, pos); 
			if(isOne){
				countOne += 1;
			}
			isOne = false;
			
		}
		return result;
		
    }
	
	public static void main(String[] args) {
		
		System.out.println(new Solution3().countDigitOne(41));
	}
	
}
