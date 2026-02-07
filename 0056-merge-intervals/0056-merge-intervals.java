class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> res= new ArrayList<>();
        int []newInterval= intervals[0];
        res.add(newInterval);
        for(int i[]: intervals){
            if(i[0]<=newInterval[1]){
                newInterval[1]=Math.max(newInterval[1],i[1]);
            }
            else{
                newInterval=i;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()-1][]);
    }
}