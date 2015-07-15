package problems230;

import java.util.Stack;

public class Solution {
	
	private Stack<Integer> dataStack = new Stack<Integer>();
	private int k;
	private int result;
	
    public int kthSmallest(TreeNode root, int k) {
    	this.k = k;
    	bianli(root);
    	//�˴����Զ�k��ȡֵ�����жϡ�����k �� dataStack.size()���жԱ�
    	
    	return result;
    }
    
    public void bianli(TreeNode root){
    	//�������
    	if(root.left != null){
    		bianli(root.left);
    	}
    	//�����Լ�
    	dataStack.push(root.val);
    	
    	if(dataStack.size() == k){
    		result = dataStack.peek();
    	}
    	
    	//�����ұ�
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
