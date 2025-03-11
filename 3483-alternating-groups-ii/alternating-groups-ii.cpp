class Solution {
public:
    int numberOfAlternatingGroups(vector<int>& colors, int k) {
        // find the numbers formed with 1 0 1 , 0 1 0
        // now sliding window over colors 
        for(int i = 0; i < k - 1; i++) colors.push_back(colors[i]);
        int n = colors.size();
        int l = 0; int r = 1; int count = 0;
        while(r < n){
            if(colors[r] == colors[r - 1]){
                l = r;
            }

            if(r - l + 1 < k) {
                r++;
                continue;
            }
            count++; l++; r++;
        }

        return count;
        
    }
};