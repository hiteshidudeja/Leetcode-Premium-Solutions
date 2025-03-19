class Solution {
public:
    int climbStairs(int n) {
        if(n == 1) return n;
        int prev = 1; int curr = 1;
        for(int i = 1; i < n; i++){
            int temp = curr + prev; prev = curr; curr = temp;
        }

        return curr;
    }
};