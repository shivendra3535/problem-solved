class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minClosest=Integer.MIN_VALUE;
        int maxClosest=Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }
                else if(sum<target){
                    minClosest=Math.max(minClosest,sum);
                    j++;
                }
                else{
                    maxClosest=Math.min(maxClosest,sum);
                    k--;
                }    
            }
        }
        if(minClosest==Integer.MIN_VALUE) return maxClosest;
        else if(maxClosest==Integer.MAX_VALUE) return minClosest;
        return (target-minClosest)<(maxClosest-target) ? minClosest : maxClosest;
    }
}