class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]= new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int e[]: edges){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][via]!=Integer.MAX_VALUE && dist[via][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                    }
                }
            }
        }
        int minCnt=Integer.MAX_VALUE;
        int city=-1;
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(dist[i][j]<=distanceThreshold) cnt++;
            }
            if(cnt<=minCnt){
                minCnt=cnt;
                city=i;
            }
        }
        return city;
    }
}