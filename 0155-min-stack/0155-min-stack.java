class MinStack {
    Queue<Integer> q;
    Stack<Integer> minSt;
    public MinStack() {
        q= new LinkedList<>();
        minSt= new Stack<>();
    }
    
    public void push(int val) {
        int size=q.size();
        q.offer(val);
        for(int i=0; i<size; i++){
            q.offer(q.peek());
            q.poll();
        }
        if(minSt.isEmpty() || minSt.peek()>=val){
            minSt.push(val);
        }
    }
    
    public void pop() {
        int val=q.poll();
        if(minSt.peek()==val){
            minSt.pop();
        }
    }
    
    public int top() {
       return q.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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