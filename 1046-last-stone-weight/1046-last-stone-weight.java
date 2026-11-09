class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int s: stones){
            pq.offer(s);
        }
        while(pq.size()>=2){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y){
                y=x-y;
                pq.offer(y);
            }
        }
        if(pq.isEmpty()) return 0;
        return pq.peek();
    }
}