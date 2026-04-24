class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            if(!set.contains(n)){
            set.add(n);
            }
        }
        for(int n: set){
            if(!set.contains(n-1)){
                int x=n;
                int cnt=1;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}