package problems3;

public class BestSolution {
	
	/*
	 * 基本思路：
	 * 类似水桶算法，因为CHAR很少，于是建立一个长数组，存每个CHAR出现的次数，以及位置。
	 * 如果出现了重复的CHAR，则计算MAX
	 */
	public int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		int max = 0, start = 0;
		char[] str = s.toCharArray();
		int length = s.length();
		
		for(int i = 0; i < length; i++) {
		    if(map[str[i]] > 0)
		    		start =  Math.max(start, map[str[i]]);
		    map[str[i]] = i + 1;
		    max = Math.max(max, i + 1 - start);
		}
		return max;
	}
}
