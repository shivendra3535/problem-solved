class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res= new ArrayList<>();
        int mergeInterval[]=intervals[0];
        res.add(mergeInterval);
        for(int interval[]: intervals){
            if(interval[0]<=mergeInterval[1]){
                mergeInterval[1]=Math.max(interval[1],mergeInterval[1]);
            }
            else{
                mergeInterval=interval;
                res.add(mergeInterval);
            }
        }
        return res.toArray(new int[0][]);
    }
}