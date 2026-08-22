class Solution {
    public long memoization(int [][] questions, int index, long dp[]){
        if(index>=questions.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int points=questions[index][0];
        int brainpower=questions[index][1];
        long take=points+memoization(questions,index+brainpower+1,dp);
        long notTake=memoization(questions,index+1,dp);
        dp[index]=Math.max(take,notTake);
        return dp[index];
    }
    public long mostPoints(int[][] questions) {
        long dp[]= new long[questions.length];
        Arrays.fill(dp,-1);
        return memoization(questions,0,dp);
    }
}