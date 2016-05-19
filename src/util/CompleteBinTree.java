package util;


import java.util.LinkedList;

import problems222.TreeNode;

public class CompleteBinTree {
	private TreeNode root;  
    private Queue queue; 
    
    public Queue getQueue() {  
        return queue;  
    }  
  
    /** 
     * @param queue the queue to set 
     */  
    public void setQueue(Queue queue) {  
        this.queue = queue;  
    }  
  
    /** 
     * @return the root 
     */  
    public TreeNode getRoot() {  
        return root;  
    }  
  
    /** 
     * @param root the root to set 
     */  
    public void setRoot(TreeNode root) {  
        this.root = root;  
    }  
     
    public CompleteBinTree(){  
        root = null;  
    }  
    
	public  void insertNode(TreeNode node){  
        if(root == null){  
            this.setRoot(node);  
        }else{  
            queue = new Queue();  
            queue.inQueue(root);  
            while(!queue.isEmpty()){  
                TreeNode temp = queue.outQueue();  
                if(temp.left == null){  
                    temp.left = node;  
                    return;  
                }else if(temp.right== null){  
                    temp.right = node;  
                    return;  
                }else{  
                    queue.inQueue(temp.left);  
                    queue.inQueue(temp.right);  
                }  
            }  
        }  
    }// end insertNode  
	
	
	public class Queue {  
	    private LinkedList<TreeNode> list;  
	  
	    /** 
	     * @return the list 
	     */  
	    public LinkedList<TreeNode> getList() {  
	        return list;  
	    }  
	  
	    /** 
	     * @param list the list to set 
	     */  
	    public void setList(LinkedList<TreeNode> list) {  
	        this.list = list;  
	    }  
	  
	     public Queue(){  
	         list = new LinkedList<TreeNode>();  
	     }   
	       
	     public void inQueue(TreeNode node){  
	         list.add(node);  
	     }  
	       
	     public TreeNode outQueue(){  
	        return list.removeFirst();  
	     }  
	       
	     public boolean isEmpty(){  
	        return list.isEmpty();  
	     }  
	} 
	
//	class TreeNode{
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		TreeNode(int x) {
//			val = x;
//		}
//	}
}
