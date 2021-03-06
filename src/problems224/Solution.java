package problems224;

public class Solution {
	
	char totalInput[];
	
	public int calculate(String s){
	
    	if(s.length() <= 0){
    		return 0;
    	}
    	
    	totalInput = s.toCharArray();
    	
    	String result = "";
    	boolean hasOperator = false;
    	
    	
    	for(int i = 0 ; i < totalInput.length ; i ++){
    		char now = totalInput[i];
    		
    		if(now == ' '){
    			continue;
    		}
    		
    		if(now >= '0' && now <= '9'){
    			result += now;
    		}else{
    			switch (now) {
				case '+':
					
					if(hasOperator){
						
						result = calcOne(result) + now;
						hasOperator = true;
						
					}else{
						
						hasOperator = true;
						result += now;
						
					}
					
					break;
				case '-':
					
					if(hasOperator){
						
						result = calcOne(result) + now;
						hasOperator = true;
						
					}else{
						
						hasOperator = true;
						result += now;
						
					}
									
					break;
					
				case '(':
					if(i >= 1 && totalInput[i-1] == '-'){
						doReverse(i);
					}
					
					break;
				case ')':
					break;
				default:
					break;
				}
    		}
    		
    		
    	}
    	
    	result = calcOne(result);
    	
    	
    	return Integer.parseInt(result);
    }
	
	public void doReverse(int i){
		
		//未完结前括号数目
		int preNum = 0 ;
		
		for(; i < totalInput.length ; i ++){
			
			if(totalInput[i] == '('){
				
				preNum ++;
				
			}else if (totalInput[i] == ')'){
				
				preNum -- ;
				if(preNum == 0){
					break;
				}
				
			}else if(totalInput[i] == '-' || totalInput[i] == '+'){
				
				if(preNum == 1){
					if(totalInput[i] == '-' ){
						totalInput[i] = '+';
					}else{
						totalInput[i] = '-';
					}
				}
				
			}
		}
		
	}
    
	String calcOne(String s){
    	
    	if(s == ""){
    		return "0";
    	}
    	
    	String left ="";
    	String right ="";
    	boolean isLeft = true;
    	boolean preOperator = false;
    	
    	String operator = "";
    	
    	String operator2 = "";
    	
    	int result = 0;
    	
    	char input[] = s.toCharArray();
    	
    	for(int i = 0 ; i < input.length ; i ++){
    		char now = input[i];
    		if(now == ' '){
    			continue;
    		}
    		
    		if(now != '+' && now != '-' && now != '*' && now != '/'){
        		if(isLeft){
        			left += now ;
        		}else{
        			right += now;
        		}
        		continue;
        	}else{
        		if(operator == ""){
        			
        			if(i == 0 ){
        				
        				preOperator = true;
        				
        			}else{
        				operator = now+"";
                		isLeft = false;
        			}
        			
        		}else{
        			operator2 = now + "";
        		}
        		
        	}
    	}
    	
    	if(left == ""){
    		left = "0";
    	}
    	
    	int pre = 1;
    	if(preOperator){
    		pre = -1;
    	}
    	
    	switch (operator) {
		case "+":
			if(operator2 == ""){
				result = Integer.parseInt(left)*pre + Integer.parseInt(right);
				
			}else if (operator2 == "-"){
				// + -1
				result = Integer.parseInt(left)*pre - Integer.parseInt(right); 
			}
			
			break;
			
		case "-":
			if(operator2 == ""){
				result = Integer.parseInt(left)*pre - Integer.parseInt(right); 
			}else{
				//- -1
				result =  Integer.parseInt(left)*pre + Integer.parseInt(right);
			}
			break;
					
		default:
			break;
		}
    	
    	if(operator == ""){
    		return left;
    	}
        
    	return String.valueOf(result);
    	
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().calculate("2-(5-6)"));
		
	}
}