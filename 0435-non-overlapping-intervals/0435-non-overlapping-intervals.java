class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int cnt=0;
        int last[]=intervals[0];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<last[1]){
                cnt++;
            }
            else{
                last=intervals[i];
            }
        }
        return cnt;
    }
}