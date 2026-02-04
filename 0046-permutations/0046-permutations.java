class Solution {
    public void swap(int nums[],int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void permute(int []nums, int index, List<List<Integer>> res){
        if(index==nums.length){
            List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(new ArrayList<>(numList));
        }

        for(int i=index; i<nums.length; i++){
            swap(nums,i,index);
            permute(nums,index+1,res);
            swap(nums,i,index);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        permute(nums,0,res);
        return res;
    }
}