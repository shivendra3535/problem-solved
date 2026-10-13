class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        int indegree[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int p[]: prerequisites){
            int u=p[0];
            int v=p[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                int node=queue.poll();
                for(int nei: adj.get(node)){
                    if(indegree[nei]>0) indegree[nei]--;
                    if(indegree[nei]==0) queue.offer(nei);
                }
            }
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}