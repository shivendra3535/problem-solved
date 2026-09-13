class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res= new ArrayList<>();
        int[] newInterval=intervals[0];
        res.add(newInterval);
        for(int i=1; i<intervals.length; i++){
            if(newInterval[1]>=intervals[i][0]){
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
            else{
                newInterval=intervals[i];
                res.add(newInterval);
            }
        }
        int ans[][]= new int[res.size()][2];
        int j=0;
        for(int i[]: res){
            ans[j++]=i;
        }
        return ans;
    }
}