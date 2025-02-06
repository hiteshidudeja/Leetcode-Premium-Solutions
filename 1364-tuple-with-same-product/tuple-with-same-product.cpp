class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        unordered_map<int, int>map;
        int n = nums.size();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                map[nums[i] * nums[j]]++;
            }
        }

        int result = 0;

        for(auto entry : map){
            int numberOfTuples = entry.second;
            if(numberOfTuples <= 1) continue;
            result += numberOfTuples*2 * (numberOfTuples*2 - 2);
        }

        return result;
    }
};