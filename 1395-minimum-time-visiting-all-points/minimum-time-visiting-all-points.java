class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // minimum 
        int n = points.length;

        int time = 0;
        for(int i = 1; i < n; i++){
            int x1 = points[i - 1][0]; int x2 = points[i][0];
            int y1 = points[i - 1][1]; int y2 = points[i][1];
            int horizontal = Math.abs(x1 - x2); //2
            int vertical = Math.abs(y1 - y2); //3
            int diagonal = Math.min(horizontal + Math.abs(vertical - horizontal), vertical + Math.abs(vertical - horizontal));

            time += Math.min(horizontal + vertical, diagonal);
        }

        return time;
    }
}