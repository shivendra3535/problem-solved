class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj= new ArrayList<>();
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int outG[]= new int[numCourses];
        for(int p[]: prerequisites){
            int u=p[0];
            int v=p[1];
            outG[u]++;
            adj.get(v).add(u);
        }
        for(int i=0; i<numCourses; i++) if(outG[i]==0) queue.offer(i);
        List<Integer> res= new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            res.add(node);
            for(int a: adj.get(node)){
                outG[a]--;
                if(outG[a]==0) queue.offer(a);
            }
        }
        int[] output = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
           output[i] = res.get(i); 
        }
        if(res.size() != numCourses) return new int[0];
        return output;
    }
}