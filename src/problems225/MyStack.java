package problems225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	private Queue<Integer> dataQueue = new LinkedList<Integer>();
	
	private Queue<Integer> tmpQueue = new LinkedList<Integer>();
	// Push element x to the back of queue.
	// Push element x onto stack.
    public void push(int x) {
        dataQueue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	tmpQueue.clear();
    	while(dataQueue.size() > 1){
    		tmpQueue.offer(dataQueue.poll());
    	}
    	
    	dataQueue.clear();
    	dataQueue.addAll(tmpQueue);
    }

    // Get the top element.
    public int top() {
    	tmpQueue.clear();
    	while(dataQueue.size() > 1){
    		tmpQueue.offer(dataQueue.poll());
    	}
    	
    	int result = dataQueue.peek();
    	
    	tmpQueue.offer(result);
    	dataQueue.clear();
    	dataQueue.addAll(tmpQueue);
    	return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return dataQueue.isEmpty();
    }
    
}
