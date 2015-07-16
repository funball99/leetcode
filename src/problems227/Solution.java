package problems227;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> negtiveNums = new ArrayList<Integer>();
	
    public int calculate(String s) {
    	
    	String resultString = "";
    	
    	char input[] = s.toCharArray();
    	

    	//1.   1+3*45+
    	//2.   1+3+
    	//3.   1*2+
    	int operators = 0;
    	
    	boolean firstOperatorOpt= false;
    	boolean secondOperatorOpt = false;
    	
    	String tmpMultiply = "";
    	//第一次循环，去掉对应的乘除法
    	for(int i = 0 ; i < input.length ; i ++){
        	
        	char now = input[i];
        	
        	if(now >= '0' && now <= '9'){
        		
        		if(now == ' '){
        			continue;
        		}
        		
        		resultString += now ;
        		tmpMultiply += now;
        		
        		continue;
        	}else{
        		
        		switch (now) {
    			case '-':
    				operators ++;
    				if(operators == 1){
    					// 1+
    					firstOperatorOpt = false;
    					secondOperatorOpt = false;
    					resultString += now ;
    					tmpMultiply = "";
    					
    				}else if (operators == 2){
    					
						//3.   1*2+
						//2.   1+3+
						resultString = calcOne(resultString) + now;
						firstOperatorOpt = false;
						secondOperatorOpt = false;
						tmpMultiply = "";
						operators = 1;
    					
    				}else if(operators == 3){
    					//1.   1+3*45+
    					resultString = resultString.substring(0, resultString.length() - tmpMultiply.length());
    					resultString += calcOne(tmpMultiply);
    					resultString = calcOne(resultString);
    					resultString += now;
    					tmpMultiply = "";
    					operators = 1;
    				}
    				
    				
    				break;

    			case '+':
    				operators ++;
    				if(operators == 1){
    					// 1+
    					firstOperatorOpt = false;
    					secondOperatorOpt = false;
    					resultString += now ;
    					tmpMultiply = "";
    					
    				}else if (operators == 2){
    					
						//3.   1*2+
						//2.   1+3+
						resultString = calcOne(resultString) + now;
						firstOperatorOpt = false;
						secondOperatorOpt = false;
						tmpMultiply = "";
						operators = 1;
    					
    				}else if(operators == 3){
    					//1.   1+3*45+
    					resultString = resultString.substring(0, resultString.length() - tmpMultiply.length());
    					resultString += calcOne(tmpMultiply);
    					resultString = calcOne(resultString);
    					resultString += now;
    					tmpMultiply = "";
    					operators = 1;
    				}
    				break;
    				
    			case '*':
    				operators ++;
    				if(operators == 1){
    					// 1*
    					firstOperatorOpt = true;
    					secondOperatorOpt = false;
    					resultString += now ;
    					tmpMultiply += now;
    					
    				}else if (operators == 2){
    					
						//3.   1*2*
    					if(firstOperatorOpt){
    						resultString = calcOne(resultString) + now;
    						tmpMultiply = resultString;
    						firstOperatorOpt = true;
    						secondOperatorOpt = false;
    						operators = 1;
    					}else{
    						//2.   1+3*
    						firstOperatorOpt = false;
    						secondOperatorOpt = true;
    						resultString += now ;
        					tmpMultiply += now;
    					}
    					
    				}else if(operators == 3){
    					//1.   1+3*45*
    					if(secondOperatorOpt){
    						resultString = resultString.substring(0, resultString.length() - tmpMultiply.length());
    						tmpMultiply = calcOne(tmpMultiply) + now;
    						resultString += tmpMultiply;
    						operators = 2;
    						firstOperatorOpt = false;
    						secondOperatorOpt = true;
    					}
    				}
    				break;
    				
    			case '/':
    				operators ++;
    				if(operators == 1){
    					// 1*
    					firstOperatorOpt = true;
    					secondOperatorOpt = false;
    					resultString += now ;
    					tmpMultiply += now;
    					
    				}else if (operators == 2){
    					
						//3.   1*2*
    					if(firstOperatorOpt){
    						resultString = calcOne(resultString) + now;
    						tmpMultiply = resultString;
    						firstOperatorOpt = true;
    						secondOperatorOpt = false;
    						operators = 1;
    					}else{
    						//2.   1+3*
    						firstOperatorOpt = false;
    						secondOperatorOpt = true;
    						resultString += now ;
        					tmpMultiply += now;
    					}
    					
    				}else if(operators == 3){
    					//1.   1+3*45*
    					if(secondOperatorOpt){
    						resultString = resultString.substring(0, resultString.length() - tmpMultiply.length());
    						tmpMultiply = calcOne(tmpMultiply) + now;
    						resultString += tmpMultiply;
    						operators = 2;
    						firstOperatorOpt = false;
    						secondOperatorOpt = true;
    					}
    				}
    				break;
    			}
        		
        	}
        }
    	//第一次计算的收尾
    	//1.   1+3*45+
    	//2.   1+3+
    	//3.   1*2+
    	if(secondOperatorOpt || firstOperatorOpt){
    		
    		if(firstOperatorOpt){
    			//3.   1*2
    			resultString = calcOne(resultString);
    			
    		}else{
    			//1.   1+3*45
    			resultString = resultString.substring(0, resultString.length() - tmpMultiply.length());
				tmpMultiply = calcOne(tmpMultiply);
				resultString += tmpMultiply;
				resultString = calcOne(resultString);
    		}
    		
    	}else{
    		//2.   1+3
    		resultString = calcOne(resultString);
    		
    	}
    	
    	int resultNum = Integer.parseInt(resultString);
    	for(int i = 0 ; i < negtiveNums.size() ; i ++){
    		resultNum += negtiveNums.get(i);
    	}
    	
		return resultNum;
       
    }
  
    
    /**
     * 计算单个的字符串，如 3*3  3+2  44/3 等
     * @param s
     * @return
     */
    String calcOne(String s){
    	String left ="";
    	String right ="";
    	boolean isLeft = true;
    	String operator = "";
    	
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
        		operator = now+"";
        		isLeft = false;
        	}
    	}
    	
    	switch (operator) {
		case "+":
			result = Integer.parseInt(left) + Integer.parseInt(right);
			break;
			
		case "-":
			result = Integer.parseInt(left) - Integer.parseInt(right);
			break;
		
					
		case "*":
			result = Integer.parseInt(left) * Integer.parseInt(right);
			break;
		
			
		case "/":
			result = Integer.parseInt(left) / Integer.parseInt(right);
			break;


		default:
			break;
		}
    	
    	if(operator == ""){
    		return left;
    	}else{
    		if(result < 0){
        		negtiveNums.add(result);
        		result = 0;
        	}
        	
        	return String.valueOf(result);
    	}
    	
    }
    
    
    public static void main(String[] args) {
    	
    	int a  = new Solution().calculate("1");
    	System.out.println(a);
	}
}