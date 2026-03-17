class MyCircularQueue {
    private int size;
    private int queue[];
    private int front;
    private int rear;
    public MyCircularQueue(int k) {
        this.size=k;
        queue= new int[size];
        front=-1;
        rear=-1;
    }
    
    public boolean enQueue(int value) {
        if((rear+1)%size == front){
            return false;
        }
        else if(front==-1){
            front=0;
            rear=0;
            queue[rear]=value;
            return true;
        }
        else{
            rear=(rear+1)%size;
            queue[rear]=value;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(front==-1){
            return false;
        }

        if (front == rear){
            front = -1;
            rear = -1;
            return true;
        }
        else{
            queue[front]=0;
            front=(front+1)%size;
            return true;
        }
    }
    public int Front() {
        if(front==-1){
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if(front==-1){
            return -1;
        }
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return (front==-1);
    }
    
    public boolean isFull() {
        return (rear+1)%size==front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */