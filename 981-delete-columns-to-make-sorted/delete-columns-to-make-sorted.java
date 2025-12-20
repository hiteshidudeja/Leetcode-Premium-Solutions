class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int rows = strs.length;

        int result = 0;
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows - 1; j++){
                if(j + 1 < rows && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    result++; break;
                }
            }
        }

        return result;
    }
}