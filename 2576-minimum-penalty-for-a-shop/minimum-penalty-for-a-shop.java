class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int rightYes = 0; int leftNo = (int) customers.chars().filter(ch -> ch == 'N').count();

        int penalty = leftNo ; int idx = n;

        for(int i = n - 1; i >=0; i--){
            if(customers.charAt(i) == 'Y') {
                rightYes++;
            } else leftNo--;

            if(rightYes + leftNo <= penalty){
                penalty = rightYes + leftNo;
                idx = i;
            }
        }

        return idx;

    }
}