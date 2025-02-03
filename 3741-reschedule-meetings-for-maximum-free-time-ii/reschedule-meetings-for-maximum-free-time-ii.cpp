class Solution {
public:
    int maxFreeTime(int eventTime, vector<int>& startTime, vector<int>& endTime) {
        // 0  6  1  0 
        // 0 2 3 1 0 
        // is there a gap in left or right where my meeting can fit ?

        vector<int>gap;
        int end = 0;

        for(int i = 0; i < startTime.size(); i++){
            gap.push_back(startTime[i] - end);
            end = endTime[i];
        }

        gap.push_back(eventTime - end);

        vector<int>largestRight(gap.size(), 0);


        // suffix max 
        for(int i = gap.size() - 2; i >= 0; i--){
            largestRight[i] = max(largestRight[i + 1], gap[i + 1]);
        }

        int largestLeft = 0;


        int result = INT_MIN;

        for(int i = 1; i < gap.size(); i++){
            int currGap = endTime[i - 1] - startTime[i - 1];
            if(currGap <= max(largestRight[i], largestLeft))
                result = max(result, gap[i] + gap[i - 1] + currGap);
            result = max(result, gap[i] + gap[i-1]);

            largestLeft = max(largestLeft, gap[i - 1]);

        }

        return result;

    }
};