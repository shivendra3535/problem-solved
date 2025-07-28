class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
        {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result= new ArrayList<>();
        int [] newinterval=intervals[0];
        result.add(newinterval);
        for(int[]i : intervals)
        {
            if(i[0]<=newinterval[1])
            {
                newinterval[1]=Math.max(newinterval[1],i[1]);
            }
            else
            {
                newinterval=i;
                result.add(newinterval);
            }
        }
        return result.toArray(new int[0][]);
    }
}