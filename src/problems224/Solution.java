package problems224;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public int calculate(String s){
	
		int result = calcAll("(" + s + ")");
		
		return result;
	}
	
    public int calcAll(String s) {
    	
    	if(s == ""){
    		return 0;
    	}
    	
    	if(s.length() <= 0){
    		return 0;
    	}
    	
    	char input[] = s.toCharArray();
    	
    	String result = "";
    	boolean hasOperator = false;
    	
    	
    	for(int i = 0 ; i < input.length ; i ++){
    		char now = input[i];
    		
    		if(i == 0){
    			continue;
    		}
    		
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
					String tmp = s.substring(i,getClouIndex(s.substring(i)+1));
					result += calcAll(tmp);
					result = calcOne(result);
					i += tmp.length();
					hasOperator = false;
					break;
				case ')':
					i = input.length;
					break;
				default:
					break;
				}
    		}
    		
    		
    	}
    	
    	result = calcOne(result);
    	
    	
    	int resultNum = Integer.parseInt(result);
    	
    	
    	return resultNum;
    }
    
    private int getClouIndex(String s) {
    	int result = 0;
    	int leftTime = 0 ;
    	
    	char[] input = s.toCharArray();
    	
    	for(int i = 0 ; i < input.length ; i ++){
    		
    		if(input[i] == ')'){
    			if(leftTime == 0){
    				result = i;
    				break;
    			}else{
    				leftTime -- ;
    			}
    		}
    		if(input[i] == '('){
    			leftTime++;
    		}
    		
    	}
    	
		return result;
	}

	String calcOne(String s){
    	
    	if(s == ""){
    		return "0";
    	}
    	
    	String left ="";
    	String right ="";
    	boolean isLeft = true;
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
        			operator = now+"";
            		isLeft = false;
        		}else{
        			operator2 = now + "";
        		}
        		
        	}
    	}
    	
    	if(left == ""){
    		left = "0";
    	}
    	
    	switch (operator) {
		case "+":
			if(operator2 == ""){
				result = Integer.parseInt(left) + Integer.parseInt(right);
			}else if (operator2 == "-"){
				// + -1
				result = Integer.parseInt(left) - Integer.parseInt(right);
			}
			
			break;
			
		case "-":
			if(operator2 == ""){
				result = Integer.parseInt(left) - Integer.parseInt(right);
			}else{
				//- -1
				result = Integer.parseInt(left) + Integer.parseInt(right);
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
    	System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
		
	}
}