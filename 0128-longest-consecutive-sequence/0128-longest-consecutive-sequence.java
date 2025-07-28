class Solution {
    public int longestConsecutive(int[] nums) {
      int n=nums.length;
      if(n==0) return 0;
      int longest=1;
      Set<Integer> ans_set= new HashSet<>();
      int cnt=0;
      for(int i=0; i<n; i++)
      {
        ans_set.add(nums[i]);
      }
      for(int element:ans_set)
      {
        if(!ans_set.contains(element-1))//if set does not contains element-1
        {
            cnt=1;
            int x=element;
            while(ans_set.contains(x+1))
            {
                x=x+1;
                cnt++;
            }
            longest= Math.max(cnt,longest);
        }

      }
      return longest;

    }
}