class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // first interval which has ni[0] < interval[1], (min ni[0], intercal[0])
        // iterate till ni[1] <= intervali[1] && ni[1] >= interval[0] (maxni[1]. intervali[1]);

        // three cases
        // new interval is non overlapping
        // end[i] >= start[newInterval]
        // start[j] <= end[newInterval] (last j such th)


        int n = intervals.length;

        List<int[]> list = new ArrayList<>();

        int start = newInterval[0]; int end = newInterval[1]; int i = 0;

        while(i < n && intervals[i][1] < start){
            list.add(intervals[i]); i++;
        }

        while(i < n && intervals[i][0] <= end){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end); i++;
        }

        list.add(new int[]{start, end});

        while(i < n) {
            list.add(intervals[i]); i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}