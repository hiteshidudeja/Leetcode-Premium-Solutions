class Solution {
public:
    int countDays(int days, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());
        int n = meetings.size(); int prev = 0; int count = 0;
        for(int i = 0; i < n; i++){
            if(prev < meetings[i][0]){
                count += meetings[i][0] - prev - 1;
            }

            prev = max(prev, meetings[i][1]);
        }
        count += max(0, days - prev);
            
        return count;
    }
};