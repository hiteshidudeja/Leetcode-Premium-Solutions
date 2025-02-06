/* The knows API is defined for you.
      bool knows(int a, int b); */

class Solution {
public:
    int findCelebrity(int n) {
        // celebrity should have n - 1 incoming edges 
        // n**2 
        vector<int>incoming(n, 0);
        vector<int>outgoing(n, 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(knows(i, j)) {
                    incoming[j]++;
                    outgoing[i]++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(incoming[i] == n - 1 && outgoing[i] == 0) return i;
        }

        return -1;
    }
};