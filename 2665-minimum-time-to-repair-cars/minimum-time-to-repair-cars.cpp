class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        long long lo = 0; long long hi = 1LL * *min_element(ranks.begin(), ranks.end()) * cars * cars;

        auto possible = [&](long long time){
            long long ans = 0;
            for(int &rank : ranks){
                ans += sqrt(time / rank);
            }

            return ans >= cars;
        }; 
        long long ans = -1;
        while(lo <= hi){
            long long mid = lo + (hi - lo)/2;
            if(possible(mid)){
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }

        return ans;

    }
};