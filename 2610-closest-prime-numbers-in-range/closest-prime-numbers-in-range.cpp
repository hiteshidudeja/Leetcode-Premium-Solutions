class Solution {
private:
    void createSeive(vector<bool>&seive){
        int n = seive.size(); seive[0] = false; seive[1] = false;
        for(int i = 2; i * i < n; i++){
            if(seive[i]){
            for(int j = i * i; j < n; j += i){
                seive[j] = false;
            }
            }
        }
    }
public:
    vector<int> closestPrimes(int left, int right) {
        vector<bool>seive(right + 1, true);
        createSeive(seive);
        vector<int>primes;
        for(int i = left; i <= right; i++){
            if(seive[i]) primes.push_back(i);
        }

        int n = primes.size(); 
        if(n < 2) return {-1, -1};
        vector<int>result(2);

        int minDiff = INT_MAX;

        for(int i = 1; i < primes.size(); i++){
            if(primes[i] - primes[i - 1] < minDiff){
                minDiff = primes[i] - primes[i - 1];
                result[0] = primes[i - 1];
                result[1] = primes[i];
            }
        }

        return result;

    }
};