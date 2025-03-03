class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int n = nums.size();
        vector<int>result(n);
        int less = 0; int great = n - 1;

        for(int i = 0, j = n - 1; i < n; i++, j--){
            if(nums[i] < pivot){
                result[less] = nums[i]; less++;
            }

            if(nums[j] > pivot){
                result[great] = nums[j]; great--;
            }
        }

        for(int i = less; i <= great; ++i) result[i] = pivot;

        return result;
    }
};