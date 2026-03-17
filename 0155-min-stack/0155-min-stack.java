class MinStack {
    Queue<Integer> q;
    Stack<Integer> minStack;
    public MinStack() {
        minStack= new Stack<>();
        q=new LinkedList<>();
    }
    
    public void push(int val) {
        int size=q.size();
        q.offer(val);
        for(int i=0; i<size; i++){
            q.offer(q.peek());
            q.poll();
        }

        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(q.isEmpty()) return;

        int removed = q.poll();

        if(removed == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return q.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */