package problems230;

import java.util.Stack;

public class Solution {
	
	private Stack<Integer> dataStack = new Stack<Integer>();
	private int k;
	private int result;
	
    public int kthSmallest(TreeNode root, int k) {
    	this.k = k;
    	bianli(root);
    	//此处可以对k的取值进行判断。。。k 和 dataStack.size()进行对比
    	
    	return result;
    }
    
    public void bianli(TreeNode root){
    	//遍历左边
    	if(root.left != null){
    		bianli(root.left);
    	}
    	//遍历自己
    	dataStack.push(root.val);
    	
    	if(dataStack.size() == k){
    		result = dataStack.peek();
    	}
    	
    	//遍历右边
    	if(root.right != null){
    		bianli(root.right);
    	}
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		a.left = b;
		System.out.println(new Solution().kthSmallest(a, 1));
	}
}
