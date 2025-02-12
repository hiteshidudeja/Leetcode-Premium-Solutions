class Solution {
private:
    int calculateSumDigits(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num = num/10;
        }

        return sum;
    }
public:
    int maximumSum(vector<int>& nums) {
        // 
        unordered_map<int, int>map;
        int result = -1;
        for(auto num : nums){
            int sumDigits = calculateSumDigits(num);
            if(map.find(sumDigits) != map.end()) result = max(result, num + map[sumDigits]);
            map[sumDigits] = max(num, map[sumDigits]);
        }

        return result;
    }
};