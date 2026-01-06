class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // minimum value // sum // number of negatives

        int numNegatives = 0;
        int minVal = Integer.MAX_VALUE; long sum = 0;

        int n = matrix.length; int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int num = matrix[i][j];
                if(num < 0) numNegatives++; 
                sum += Math.abs(num);
                minVal = Math.min(minVal, Math.abs(num));
            }
        }

        if(numNegatives % 2 == 1) sum -= 2 * minVal;
        return sum; 
    }
}