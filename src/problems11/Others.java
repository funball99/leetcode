package problems11;



/*
 * 别人的算法。。。看起来貌似有漏洞，实际想想貌似又没有。。。很快
 */
public class Others {
	public int maxArea(int[] height) {
	    int max = 0, i = 0, j = height.length - 1;
	    while(i < j)
	        max = Math.max(max, (j - i) * (height[i] < height[j] ? height[i++] : height[j--]));
	    return max;
	}
	
	 public int maxArea2(int[] height) {
        int left=0;
        int right = height.length-1;
        int max=0,area;
        while(left<right) {
            int l = height[left];
            int r = height[right]; 
            if( l > r){
                area = (right-left) * r;
                while (height[--right] <= r);
            }else{
                area = (right-left) * l;
                while (height[++left] < l);
            }
            if (area > max) max = area;
        }
        return max;
    }
}
