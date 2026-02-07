class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res= new ArrayList<>();
        int ele1=-1;
        int cnt1=0;
        int ele2=-1;
        int cnt2=0;
        for(int i=0; i<nums.length; i++){
            if(cnt1==0 && ele2!=nums[i]){
                cnt1=1;
                ele1=nums[i];
            }
            else if(cnt2==0 && ele1!=nums[i]){
                cnt2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1){
                cnt1++;
            }
            else if(nums[i]==ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        int freq1=0;
        int freq2=0;
        for(int n: nums){
            if(n==ele1) freq1++;
            if(n==ele2) freq2++;
        }
        if(ele1==ele2 && freq1>nums.length/3){
            res.add(ele1);
            return res;
        }

        if(freq1>nums.length/3){
            res.add(ele1);
        }

        if(freq2>nums.length/3){
            res.add(ele2);
        }
        return res;
    }
}