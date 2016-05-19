package problems222;

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
 * 
 * 
 *
 * @date 2016年5月19日 上午10:58:05
 */


//日。。。超时了。。
public class Solution {
	/*
	 * 基本思路:
	 * 1.根节点，最左，取得树深度h
	 * 2.取最后一行缺了多少个节点
	 * 		2.1 根节点最右，取深度h2
	 * 		2.2 如果h2 != h ，取最右的时候，向左一个
	 * 		2.3 直到h2 == h ，此时可以得到最后一行的节点数
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
		
		int result = 0;
		
		if(root.right != null){
			result += getLastLine(root.right,depth,now + 1);
		}else{
			if(depth != now){
				result += 1;
			}
		}
		
		if(root.left != null){
			result += getLastLine(root.left,depth,now + 1);
		}else{
			if(depth != now){
				result += 1;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a21 = new TreeNode(1);
		TreeNode a22 = new TreeNode(1);
		TreeNode a31 = new TreeNode(1);
		TreeNode a32 = new TreeNode(1);
		TreeNode a33 = new TreeNode(1);
		TreeNode a34 = new TreeNode(1);
		TreeNode a41 = new TreeNode(1);
		TreeNode a42 = new TreeNode(1);
		TreeNode a43 = new TreeNode(1);
		
		
		a1.left = a21;
		a1.right = a22;
		a21.left = a31;
		a21.right = a32;
		a22.left = a33;
		a22.right = a34;
		a31.left = a41;
		a31.right = a42;
		a32.left = a43;
		
		System.out.println(new Solution().countNodes(a1));
		
	}
}
