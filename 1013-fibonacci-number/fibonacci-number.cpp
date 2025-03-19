class Solution {
public:
    int fib(int n) {
        if(n == 0 || n == 1) return n;
        int curr = 1; int prev = 0; 
        for(int i = 1; i < n; i++){
            int temp = curr + prev;
            prev = curr; curr = temp;
        }

        return curr;
    }
};