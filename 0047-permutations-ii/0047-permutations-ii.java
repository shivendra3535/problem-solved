class Solution {
    public void swap(int nums[], int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void permutation(int []nums, int index, HashSet<List<Integer>> res){
        if(index==nums.length){
            List<Integer> temp= new ArrayList<>();
            for(int n: nums) temp.add(n);
            res.add(temp);
            return;
        }

        for(int i=index; i<nums.length; i++){
            
            swap(nums,i,index);
            permutation(nums,index+1,res);
            swap(nums,i,index);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> res= new HashSet<>();
        permutation(nums,0,res);
        List<List<Integer>> ds= new ArrayList<>();
        for(List<Integer> l: res){
            ds.add(l);
        }
        return ds;
    }
}