class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int max=0;
        for(int n: set){
            if(!set.contains(n-1)){
                int x=n;
                int cnt=1;
                while(set.contains(x+1)){
                    cnt++;
                    x+=1;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}