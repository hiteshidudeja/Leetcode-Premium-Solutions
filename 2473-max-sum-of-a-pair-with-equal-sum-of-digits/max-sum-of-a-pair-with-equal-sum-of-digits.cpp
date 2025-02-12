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
        vector<int>mapSumDigits(82, -1);
        int result = -1;
        for(auto num : nums){
            int sumDigits = calculateSumDigits(num);
            if(mapSumDigits[sumDigits] != -1) result = max(result, num + mapSumDigits[sumDigits]);
            mapSumDigits[sumDigits] = max(num, mapSumDigits[sumDigits]);
        }

        return result;
    }
};