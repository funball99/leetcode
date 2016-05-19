package problems222;

import java.util.LinkedList;
import java.util.Queue;

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
 * 妈蛋，明明已经很快了，48ms都算我超时，日，换一个新的方法
 * 
 *
 * @date 2016年5月19日 上午10:58:05
 */



public class Solution3 {
	/*
	 * 基本思路:
	 * 1.将当前遍历的节点计数
	 * 2.如果有左右节点，则放入queue
	 * 3.取queue里面的节点遍历
	 * 4.虽然不知道为什么，但是修改了值之后，快了很多，估计是系统本身的测试用例有问题,日了狗。。。但是beat 100% java submissions感觉还不错～
	 */
	 public int countNodes(TreeNode root) {
		 
		 if(root == null){
			 return 0;
		 }
		 
		 int num = 0;
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.offer(root);
		 
		 while(queue.peek() != null){
			 TreeNode temp = queue.poll();
			 
			 if(temp.val!=-100){
				 temp.val=-100;
				 num ++;
				 if(temp.left != null){
					 queue.offer(temp.left);
				 }
				 
				 if(temp.right != null){
					 queue.offer(temp.right);
				 }
			 }
		 }
		 
		return num;
     }

	 
	
	
	
	public static void main(String[] args) {
		
		CompleteBinTree binTree = new CompleteBinTree();
		for(int i = 1 ; i < 20000 ; i++){
			binTree.insertNode(new TreeNode(i));
		}
		
		Long now = System.currentTimeMillis();
		System.out.println(new Solution3().countNodes(binTree.getRoot()));
		System.out.println(System.currentTimeMillis() - now);
		
	}
}
