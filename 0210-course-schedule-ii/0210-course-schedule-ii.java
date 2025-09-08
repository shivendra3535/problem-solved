class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        int indegree[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]: prerequisites){
            int u=e[0];
            int v=e[1];
            indegree[u]++;
            adj.get(v).add(u);
        }
        Queue<Integer> queue= new LinkedList<>();
        int order[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
               queue.offer(i);
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            order[i++]=cur;
            for(int a: adj.get(cur)){
                indegree[a]--;
                if(indegree[a]==0){
                    queue.offer(a);
                }
            }
        }
       if (i != numCourses) {
            return new int[0];
        }

        return order;
    }
}