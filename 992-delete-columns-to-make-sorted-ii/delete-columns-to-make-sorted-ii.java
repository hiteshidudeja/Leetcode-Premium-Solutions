class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length; //3
        int cols = strs[0].length(); //2

        boolean[] sorted = new boolean[rows - 1]; int result = 0;

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows - 1; j++){
                if(!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)){
                    result++; break;
                }

                if(rows >= 2 && j < rows - 2) continue;

                for(int k = 0; k < rows - 1; k++){
                    sorted[k] |= strs[k].charAt(i) < strs[k+ 1].charAt(i);
                }
            }
        }

        return result;
    }
}