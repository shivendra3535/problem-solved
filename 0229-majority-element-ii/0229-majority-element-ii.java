class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1=-1;
        int ele2=-1;
        int cnt1=0;
        int cnt2=0;
        for(int n: nums){
            if(cnt1==0 && ele2!=n){
                ele1=n;
                cnt1=1;
            }
            else if(cnt2==0 && ele1!=n){
                ele2=n;
                cnt2=1;
            }
            else if(n==ele1) cnt1++;
            else if(n==ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int n: nums){
            if(n==ele1) cnt1++;
            if(n==ele2) cnt2++;
        }
        List<Integer> res= new ArrayList<>();
        if(ele1==ele2 && cnt1>nums.length/3){ 
            res.add(ele1);
            return res;
        }
        if(cnt1>nums.length/3) res.add(ele1);
        if(cnt2>nums.length/3) res.add(ele2);
        return res;
    }
}