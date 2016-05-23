package problems4;

/**
 * 
 * @背锅人 wilsonlee
 *
 * @date 2016年5月20日 上午11:22:34
 */

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Solution {
	/*
	 * 基本思路:
	 * 1.两个数组合并
	 * 2.取中位数
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] array = new int[m+n];
	    double result = 0.0;
	    
	    int i=0,j=0,a=0;
	    
	    while(i < nums1.length || j < nums2.length){
	    	
	    		if(i >= nums1.length){
	    			array[a++] = nums2[j++];
	    			continue;
	    		}else if(j >= nums2.length){
	    			array[a++] = nums1[i++];
	    			continue;
	    		}
	    	
		    	if(nums1[i] > nums2[j]){
		    		array[a++] = nums2[j++];
		    }else{
		    		array[a++] = nums1[i++];
		    }
	    }
	    
	    if(array.length % 2 != 0){
	    		result =array[array.length/2];
	    }else{
	    		result = new Double((array[array.length/2] + array[array.length/2 - 1]));
	    		result /= 2;
	    }
	    
	    return result;
    }
	
	public static void main(String[] args) {
		int [] a1 = {};
		int []a2 = {2,3};
		System.out.println(new Solution().findMedianSortedArrays(a1, a2));
	}
}
