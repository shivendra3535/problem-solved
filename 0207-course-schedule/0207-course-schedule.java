class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int cnt=0;
        while(!queue.isEmpty()){
            cnt++;
            int node=queue.poll();
            for(int a: adj.get(node)){
                outG[a]--;
                if(outG[a]==0) queue.offer(a);
            }
        }
        return cnt==numCourses;
    }
}