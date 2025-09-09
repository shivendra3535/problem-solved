class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> reverseAdj= new ArrayList<>();
        int V= graph.length;
        int indegree[]= new int[V];
        for(int i=0; i<V; i++){
            reverseAdj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int a: graph[i]){
                reverseAdj.get(a).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue= new LinkedList<>();
        Stack<Integer> stack= new Stack<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int cur= queue.poll();
            stack.push(cur);
            for(int a: reverseAdj.get(cur)){
                indegree[a]--;
                if(indegree[a]==0){
                    queue.offer(a);
                }            
            }
        }
        List<Integer> eSafe= new ArrayList<>();
        while(!stack.isEmpty()){
            eSafe.add(stack.pop());
        }
        Collections.sort(eSafe);
        return eSafe;
    }
}