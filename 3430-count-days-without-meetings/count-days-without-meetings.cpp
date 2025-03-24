class Solution {
public:
    int countDays(int days, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());
        int n = meetings.size(); int prev = meetings[0][1]; int count = meetings[0][0] - 1;
        for(int i = 1; i < n; i++){
            if(prev < meetings[i][0]){
                count += meetings[i][0] - prev - 1;
            }

            prev = max(prev, meetings[i][1]);
        }
        count += max(0, days - prev);
            
        return count;
    }
};