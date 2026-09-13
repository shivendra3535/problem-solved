class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int cnt=0;
        int newInterval[]=intervals[0];
        for(int i=1; i<intervals.length; i++){
            if(newInterval[1]>intervals[i][0]) cnt++;
            else{
                newInterval=intervals[i];
            }
        }
        return cnt;
    }
}