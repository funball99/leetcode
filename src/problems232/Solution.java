package problems232;

import java.util.Stack;

public class Solution {
	
	private Stack<Integer> dataStack = new Stack<Integer>();
	
	private Stack<Integer> tmpStack  = new Stack<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        dataStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(dataStack.empty()){
    		return ;
    	}
    	
    	//move dataStack to tmpStack;
    	while(!dataStack.isEmpty()){
    		tmpStack.push(dataStack.pop());
    	}
    	
    	//remove the element of the queue
    	tmpStack.pop();
    	
    	//move tmpStack to dataStack;
    	while(!tmpStack.isEmpty()){
    		dataStack.push(tmpStack.pop());
    	}
    	
    }

    // Get the front element.
    public int peek() {
    	
    	if(dataStack.empty()){
    		return 0;
    	}
    	
    	//move dataStack to tmpStack;
    	while(!dataStack.isEmpty()){
    		tmpStack.push(dataStack.pop());
    	}
    	
    	//remove the element of the queue
    	int result = tmpStack.peek();
    	
    	//move tmpStack to dataStack;
    	while(!tmpStack.isEmpty()){
    		dataStack.push(tmpStack.pop());
    	}
    	
    	return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return dataStack.isEmpty();
    }
    
    public static void main(String[] args) {
    	Solution q = new Solution();
    	q.push(1);
    	q.push(2);
    	q.push(3);
    	
    	System.out.println(q.peek() + "");
    	
    	q.pop();
    	q.pop();
    	System.out.println(q.empty());
    	
    	System.out.println(q.peek() + "");
    	
    	q.pop();
    	System.out.println(q.empty());
    	
	}
}
