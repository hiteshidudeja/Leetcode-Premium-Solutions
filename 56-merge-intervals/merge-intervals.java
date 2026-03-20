class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        // sorted 
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < n;){
            int start = intervals[i][0]; int endTime = intervals[i][1];
            while(i < n - 1 && endTime >= intervals[i + 1][0]) {
                i++; endTime = Math.max(endTime, intervals[i][1]);
            }

            int end = endTime;
            result.add(new int[]{start, end});
            i++;
        }

        int[][] resultArr = result.toArray(new int[result.size()][]);
        return resultArr;
    }
}