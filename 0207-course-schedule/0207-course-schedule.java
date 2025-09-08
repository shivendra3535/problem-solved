class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        int indegree[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]: prerequisites){
            int u=e[0];
            int v=e[1];
            indegree[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> queue= new LinkedList<>();
        int cnt=0;
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
               queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            cnt++;
            for(int a: adj.get(cur)){
                indegree[a]--;
                if(indegree[a]==0){
                    queue.offer(a);
                }
            }
        }
        if(cnt==numCourses) return true;
        return false;
    }
}