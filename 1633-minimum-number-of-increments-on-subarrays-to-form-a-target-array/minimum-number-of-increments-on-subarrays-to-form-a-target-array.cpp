class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        // [0 0 0 0 0] -> [1 2 3 2 1] [1 1 1 -1 - 1]
        // [0 0 0 0] -> [3 1 1 2] [ 3 -2 0 -1]
        // 0 0 0 0 0 -> [3,1,5,4,2] // 1 
        int result = target[0];
        for(int i = 1; i < target.size(); i++){
            if(target[i] > target[i-1]) result += target[i] - target[i - 1];
        }

        return result;
    }
};