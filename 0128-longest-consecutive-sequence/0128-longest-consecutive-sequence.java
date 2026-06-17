class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCnt=0;
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        for(int n: set){
            if(!set.contains(n-1)){
                int x=n;
                int cnt=1;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                maxCnt=Math.max(maxCnt,cnt);
            }
        }
        return maxCnt;
    }
}