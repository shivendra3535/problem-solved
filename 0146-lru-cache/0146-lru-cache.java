class LRUCache {
    int capacity;
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer, Node> lruMap;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        lruMap=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!lruMap.containsKey(key)) return -1;
        Node curr=lruMap.get(key);
        curr.prev.next=curr.next;
        if(curr.next!=null) curr.next.prev=curr.prev;
        curr.next=head.next;
        if(head.next!=null) head.next.prev=curr;
        head.next=curr;
        curr.prev=head;
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(!lruMap.containsKey(key)){
            Node newNode=new Node(key,value);
            newNode.next=head.next;
            if(head.next!=null){
                head.next.prev=newNode;
            }
            head.next=newNode;
            newNode.prev=head;
            lruMap.put(key, newNode);
        }
        else{
            Node curr=lruMap.get(key);
            curr.val=value;

            curr.prev.next=curr.next;
            if(curr.next!=null) curr.next.prev=curr.prev;
            curr.next=head.next;
            if(head.next!=null) head.next.prev=curr;
            head.next=curr;
            curr.prev=head;
        }

        if(lruMap.size()>capacity){
            Node lastNode=tail.prev;
            Node secondLast=tail.prev.prev;
            if(secondLast!=null) secondLast.next=tail;
            tail.prev=secondLast;
            if(lastNode!=null){
                lastNode.next=null;
                lastNode.prev=null;
            }
            lruMap.remove(lastNode.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */