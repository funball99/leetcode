package problems228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> result = new ArrayList<String>();
    	
    	if(nums.length == 0){
    		return result;
    	}
    	
    	int from = 0;
    	int now = 0;
    	
    	for(int i = 0 ; i < nums.length ; i ++){
    		
    		if(i == 0){
    			now = nums[i];
    			from = now;
    			continue;
    		}
    		
    		if(now + 1 == nums[i]){
    			now += 1; 
    			continue;
    			
    		}else{
    			if(from != now){
    				result.add(from + "->" + now);
    			}else{
    				result.add(from+"");
    			}
    			now = nums[i];
    			from = now;
    		}
    		
    	}
    	
		if(from != now){
			result.add(from + "->" + now);
		}else{
			result.add(from+"");
		}
			
    	
    	return result;
    }
}