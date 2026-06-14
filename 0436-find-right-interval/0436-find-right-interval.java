class Solution {
    public int find(int [][] intervals, int target,HashMap<int[], Integer> map){
        int low=0;
        int high=intervals.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(intervals[mid][0]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(ans!=-1) return map.get(intervals[ans]);
        return -1;
    }
    public int[] findRightInterval(int[][] intervals) {
        HashMap<int[], Integer> map= new HashMap<>();
        for(int i=0; i<intervals.length; i++){
            map.put(intervals[i],i);
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int res[]= new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            int ans=find(intervals,intervals[i][1],map);
            res[map.get(intervals[i])]=ans;
        }
        return res;
    }
}