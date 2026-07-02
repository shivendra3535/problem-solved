class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res= new ArrayList<>();
        int newInterval[]=intervals[0];
        res.add(newInterval);
        for(int interval[]: intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(interval[1],newInterval[1]);
            }
            else{
                newInterval=interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[0][]);
    }
}