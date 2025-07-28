class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod=1_000_000_007;
        Arrays.sort(nums);
        int n= nums.length;
        // we have to create precomputed power
        int pow[]= new int[n];
        pow[0]=1;
        for(int i=1; i<n; i++){
            pow[i]=(pow[i-1]*2) % mod; //we are taking mod to prevent range 
        }
        int result=0;
        int left=0;
        int right=n-1;
        while(left<=right){
            if(nums[left] + nums[right] <= target){
                result= (result + pow[right-left]) % mod;
                left++;  
            }
            else{
            right--;
            }
        }
        return result;
}
}