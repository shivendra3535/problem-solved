class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int lng=0;
        for(int n: set){
            if(!set.contains(n-1)){
                int x=n;
                int cnt=1;
                while(set.contains(x+1)){
                    x++;
                    cnt++;
                }
                lng=Math.max(lng,cnt);
            }
        }
        return lng;
    }
}