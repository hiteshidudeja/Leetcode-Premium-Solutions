class Solution {
    private boolean isBeautiful(int number){
        int[] frequency = new int[10];
        while(number > 0){
            int last = number % 10; if (last == 0) return false;
            frequency[last]++; number = number / 10;
        }

        for(int i = 1; i < 10; i++){
            if(frequency[i] > 0 && frequency[i] != i) return false;
        }

        return true;


    }
    public int nextBeautifulNumber(int n) {
        for(int i = n + 1; i < 1e7 + 1; i++){
            if(isBeautiful(i)) return i;
        }

        return -1;
    }
}