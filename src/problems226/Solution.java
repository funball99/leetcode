package problems226;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        
    	if(root == null){
    		return root;
    	}
    	
    	
    	//��ת����
    	if(root.left != null){
    		invertTree(root.left);
    	}
    	
    	
    	//��ת����
    	if(root.right != null){
    		invertTree(root.right);
    	}
       
    	//��ת����
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        return root;
    }
}
