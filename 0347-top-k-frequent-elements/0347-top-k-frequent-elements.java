class Solution {
    class Pair{
        int n;
        int freq;
        Pair(int n, int freq){
            this.n=n;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.freq,b.freq));
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n: map.keySet()){
            pq.offer(new Pair(n,map.get(n)));
            if(pq.size()>k) pq.poll();
        }
        int ans[]= new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll().n;
        }
        return ans;
    }
}