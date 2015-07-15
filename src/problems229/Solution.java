package problems229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> input = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0 ; i < nums.length ; i ++){
        	input.add(nums[i]);
        }
        
        //快排(实现我就不写了。。。)
        Collections.sort(input);
        
        //总长度
        int totolLength = input.size();
        int timesRequred = totolLength/3;
        
        int prev = 0;
        int tmp = 0;
        int times = 1;
        boolean added = false;
        
        for(int i = 0 ; i < input.size() ; i ++){
        	tmp = input.get(i);
        	if(tmp == prev && i != 0){
        		
        		times ++;
        		
        	}else{
        		
        		prev = tmp;
        		added = false;
        		times = 1;
        		
        	}
        	
        	if(times > timesRequred && added == false){
        		result.add(tmp);
        		added = true;
        	}
        	
        }
        
        return result;
    }
}
