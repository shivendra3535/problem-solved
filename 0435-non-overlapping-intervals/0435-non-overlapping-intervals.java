import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals based on their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 0;
        int[] lastInterval = intervals[0]; // Initialize with the first interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastInterval[1]) {
                // Overlapping interval, increment cnt
                cnt++;
            } else {
                // No overlap, update lastInterval
                lastInterval = intervals[i];
            }
        }
        return cnt;
    }
}
