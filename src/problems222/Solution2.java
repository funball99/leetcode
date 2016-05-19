package problems222;

import util.CompleteBinTree;

/**
 * 
 * @背锅人 wilsonlee
 * 
 * 
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * 取完全二叉树的结点数
 * 
 * 因为超时了，在Solution.java上做修改，不用最后一个的方式，用二分查找，会快很多.
 * 
 *
 * @date 2016年5月19日 上午10:58:05
 */



public class Solution2 {
	/*
	 * 基本思路:
	 * 1.根节点，最左，取得树深度h
	 * 2.取最后一行缺了多少个节点
	 * 		2.1 取最后一行最大数字
	 * 		2.2 取中位数，判定是否有节点
	 * 		2.3 二分法找到最后一行一共有多少节点
	 * 3.计算
	 */
	 public int countNodes(TreeNode root) {
		 
		 if(root == null){
			 return 0;
		 }
		 
		 // 1
		 int h = getDepth(root);
		 
		 // 2
		 int last = getLastLine(root,h,1);
		 
		 // 3
	     return  (int)Math.pow(2, h) - 1 - last;
     }

	 
	//取树深度
	private int getDepth(TreeNode root) {
		int i = 1 ;
		while(root.left != null){
			i ++;
			root = root.left;
		}
		return i;
	}
	
	//取最后一行缺了多少个节点
	private int getLastLine(TreeNode root,int depth,int now) {
		
		//最后一行满格是多少个
		int max = (int)Math.pow(2, depth) - 1;
		int min = (int)Math.pow(2, depth-1);
				
				
		//二分法
		int left = min;
		int right = max;
		int mid = (left+right)/2;
		
		while(left < right){
			
			if(isLastLine(depth, root, mid)){
				
				left = mid + 1;
				
			}else{
				
				right = mid - 1;
			}
			
			mid = (left+right)/2;
			
		}
		
		
		if(isLastLine(depth, root, mid)){
			return max-mid;
		}else{
			return max-mid+1;
		}
	}
	
	public boolean isLastLine(int depth,TreeNode root,int pos){
		int nowDepth = 1;
		
		char[] charArray = Integer.toBinaryString(pos).toCharArray();
		int iterator = 1;
		
		while(nowDepth != depth && root != null && iterator < charArray.length){
			
			char x = charArray[iterator];
			
			if(x == '0'){
				root = root.left;
			}else if(x == '1'){
				root = root.right;
			}
			nowDepth ++ ;
			iterator ++;
		}
		
		return root != null;
	}
	
	
	public static void main(String[] args) {
		
		
		int [] a = new int[11];
				
		
		
		CompleteBinTree binTree = new CompleteBinTree();
		for(int i = 1 ; i < 2353 ; i++){
			binTree.insertNode(new TreeNode(i));
		}
		
		
		
		System.out.println(new Solution2().countNodes(binTree.getRoot()));
		
	}
}
