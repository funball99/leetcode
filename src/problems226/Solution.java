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
    	
    	
    	//反转左树
    	if(root.left != null){
    		invertTree(root.left);
    	}
    	
    	
    	//反转右树
    	if(root.right != null){
    		invertTree(root.right);
    	}
       
    	//反转本身
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        return root;
    }
}
