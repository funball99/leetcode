package problems28;


/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年6月8日 下午5:16:57
 */


/*
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.
 */
public class Solution {
	/*
	 * 基本思路:
	 * 简单说，就是重写一个indexOf方法了,JDK里面附带String.java的方法我看了，n2,所以我就不想太多了，直接n2方法
	 */
    public int strStr(String haystack, String needle) {
    		if(haystack == null || needle == null){
    			return -1;
    		}
        char[] src = haystack.toCharArray();
        char[] key = needle.toCharArray();
        
        int index = 0;
        int key_length = key.length;
        if(key_length > src.length){
        		return -1;
        }else if(key_length == 0){
        		return 0;
        }
        
        for(int i= 0 ; i < src.length ; i ++){
        	
        	
        		int j = i;
        		char x =  src[i];
        		
        		while(x == key[index]){
        			j++;
        			index ++;
        			if(index == key_length){
        				return i;
        			}
        			if(j == src.length){
        				return -1;
        			}
        			x =  src[j];
        		}
        		index = 0;
        		
        }
        return -1;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().strStr("mississippi", "issip"));
	}
}
