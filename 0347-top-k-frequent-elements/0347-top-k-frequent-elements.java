class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0; i<=nums.length; i++){
            res.add(new ArrayList<>());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int n: map.keySet()){
            int freq=map.get(n);
            res.get(freq).add(n);
        }
        int ans[]= new int[k];
        int i=0;
        for(int j=nums.length; j>0; j--){
            for(int n: res.get(j)){
                ans[i++]=n;
                k--;
                if(k==0) return ans;
            }
        }
        return new int[]{-1,-1};
    }
}