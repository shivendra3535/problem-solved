class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) { 
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
            int diff=Integer.compare(Math.abs(b-x),Math.abs(a-x));
            if(diff==0) return Integer.compare(b,a);
            return diff;
        });
        for(int a: arr){
            pq.offer(a);
            if(pq.size()>k) pq.poll();
        }
        List<Integer> ans = new ArrayList<>(pq);
        Collections.sort(ans);

        return ans;
    }
}