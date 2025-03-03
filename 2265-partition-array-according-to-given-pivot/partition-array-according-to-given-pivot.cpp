class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        // arr1 // arr2 // arr3
        vector<int>arr1; vector<int>arr2; vector<int>arr3;

        for(int i = 0; i < nums.size(); i++){
            if(nums[i] < pivot) arr1.push_back(nums[i]);
            else if(nums[i] == pivot) arr2.push_back(nums[i]);
            else if(nums[i] > pivot) arr3.push_back(nums[i]);
        }

        for(int i = 0; i < arr2.size(); i++){
            arr1.push_back(arr2[i]);
        }
        for(int i = 0; i < arr3.size(); i++) arr1.push_back(arr3[i]);

        return arr1;
    }
};