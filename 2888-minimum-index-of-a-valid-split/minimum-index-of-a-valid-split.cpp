class Solution {
public:
    int minimumIndex(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int>map;
        for(int num : nums){
            map[num]++;
        }

        int element = -1; int countR = -1;

        for(auto &entry: map){
            if(entry.second > n/2){
                element = entry.first; countR = entry.second;
            }
        }

        // cout << element << " "<< countR<< "\n";

        if(element == -1) return -1;
        int countL = 0;

        for(int i = 1; i <= n; i++){
            if(nums[i - 1] == element) {
                countL++; countR--;
            }

            if(countL > i/2 && countR > (n - i) / 2) return i - 1;
        }

        return -1;


    }
};