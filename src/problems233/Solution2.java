package problems233;

public class Solution2 {
	
	public int countDigitOne(int n) {
		int result = n;
		
		if(n <= 0){
			return 0;
		}
		
		if(n == 1){
			return n;
		}
		
		String nStr = String.valueOf(n);
		
		for(int i = 0 ; i<nStr.length() ; i++){
			//int now = Integer.parseInt(String.valueOf(nStr.charAt(i)));
			int now = nStr.charAt(i)-48;
			int pos = nStr.length() - 1 - i;
			
			
			if(now == 1){
				if(pos == 0){
					result = result - 8;
				}else{
					continue;
				}
				
			}else if(now == 0){
				
				if(pos == 0){
					result = result - 8;
				}else{
					result = result - (int)(Math.pow(9, pos));
				}
				
			}else{
				result = result - (int)((now-1) * Math.pow(9,pos));
			}
			
		}
		return result;
		
    }
	
	public static void main(String[] args) {
		
		System.out.println(new Solution2().countDigitOne(10));
	}
	
}
