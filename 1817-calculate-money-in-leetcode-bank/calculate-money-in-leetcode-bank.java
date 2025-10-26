class Solution {
    public int totalMoney(int n) {
        int previous = 1; int money = 0; int temp = previous;
        for(int i = 1; i <= n; i++){
            money += temp; temp++;
            if(i % 7 == 0) {
                previous++; temp = previous;
            }
        }

        return money;
    }
}