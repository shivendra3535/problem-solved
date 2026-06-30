class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[]= new int[numCourses];
        List<List<Integer>> revAdj= new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            revAdj.add(new ArrayList<>());
        }
        for(int p[]: prerequisites){
            int u=p[0];
            int v=p[1];
            revAdj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) queue.offer(i);
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            cnt++;
            for(int a: revAdj.get(node)){
                indegree[a]--;
                if(indegree[a]==0){
                    queue.offer(a);
                }
            }
        }
        if(cnt==numCourses) return true;
        else return false;
    }
}