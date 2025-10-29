class Solution {
    public int smallestNumber(int n) {
        int count = 0; int result = 0;
        while(n > 0){
            n = n / 2;
            result |= (1<<count);
            count++;
        }

        return result;

    }
}