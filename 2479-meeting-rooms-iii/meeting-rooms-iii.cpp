class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        // sort wrt start time 
        // priority queue - priortize meetings with earliest end time and with smaller room number
        sort(meetings.begin(), meetings.end());

        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>>usedRooms;
        priority_queue<int, vector<int>, greater<int>>unusedRooms;
        vector<int>numMeetings(n, 0);

        for(int i = 0; i < n; i++) unusedRooms.push(i);


        for(auto meeting : meetings){
            long long start = meeting[0]; int end = meeting[1];
            while(!usedRooms.empty() && usedRooms.top().first <= start){
                int room = usedRooms.top().second;
                usedRooms.pop(); unusedRooms.push(room);
            }

            if(!unusedRooms.empty()){
                usedRooms.push({end, unusedRooms.top()});
                numMeetings[unusedRooms.top()]++;
                unusedRooms.pop();
            }
            else{
                auto [time, r] = usedRooms.top();
                usedRooms.pop();
                usedRooms.push({time + end - start, r});
                numMeetings[r]++;
            }
        }


        int result = INT_MIN; int roomNum = -1;

        for(int i = 0; i < n; i++){
            cout<<numMeetings[i]<<" ";
            if(numMeetings[i] > result) {
                result = numMeetings[i]; roomNum = i;
            }
        }

        return roomNum;

        
    }
};