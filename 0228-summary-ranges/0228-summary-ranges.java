class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int start=nums[i];
            int j=i+1;
            while(j<nums.length && nums[j]==nums[j-1]+1){
                j++;
            }
            if(i==j-1){
                res.add(""+(nums[i]));
                i++;
                continue;
            }
            res.add( new String(start+"->"+nums[j-1]));
            i=j;
        }
        return res;
    }
}