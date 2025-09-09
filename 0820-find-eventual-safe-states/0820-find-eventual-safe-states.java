class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> reverseAdj= new ArrayList<>();
        int V= graph.length;
        int outDegree[]= new int[V];
        for(int i=0; i<V; i++){
            reverseAdj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int a: graph[i]){
                reverseAdj.get(a).add(i);
                outDegree[i]++;
            }
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<V; i++){
            if(outDegree[i]==0){
                queue.offer(i);
            }
        }
        List<Integer> eSafe= new ArrayList<>();
        while(!queue.isEmpty()){
            int cur= queue.poll();
            eSafe.add(cur);
            for(int a: reverseAdj.get(cur)){
                outDegree[a]--;
                if(outDegree[a]==0){
                    queue.offer(a);
                }            
            }
        }
        Collections.sort(eSafe);
        return eSafe;
    }
}