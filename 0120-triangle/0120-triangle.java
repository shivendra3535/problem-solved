class Solution {
    public int minTot(List<List<Integer>> triangle, int day, int index,int dp[][]){
        if(day>=triangle.size()) return 0;
        if(dp[day][index]!=-1) return dp[day][index];
        int first=triangle.get(day).get(index)+minTot(triangle,day+1,index,dp);
        int second=triangle.get(day).get(index)+minTot(triangle,day+1,index+1,dp);
        dp[day][index]= Math.min(first,second);
        return dp[day][index];
    }
    public int tabulation(List<List<Integer>> triangle, int n){
        int dp[][]= new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
    public int spaceOpt(List<List<Integer>> triangle, int n){
        int nextDp[]= new int[n+1];
        for(int i=n-1; i>=0; i--){
            int tempDp[]= new int[n+1];
            for(int j=0; j<triangle.get(i).size(); j++){
                tempDp[j]=triangle.get(i).get(j)+Math.min(nextDp[j],nextDp[j+1]);
            }
            nextDp=tempDp;
        }
        return nextDp[0];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        /*int dp[][]= new int[triangle.size()][triangle.size()];
        for(int i=0; i<triangle.size(); i++){
            Arrays.fill(dp[i],-1);
        }
        return minTot(triangle,0,0,dp);*/
        //return tabulation(triangle,triangle.size());
        return spaceOpt(triangle,triangle.size());
    }
}