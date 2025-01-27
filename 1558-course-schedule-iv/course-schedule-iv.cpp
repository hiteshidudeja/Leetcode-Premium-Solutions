class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<vector<int>>grid(numCourses); vector<int>inDegrees(numCourses, 0);
        for(auto preReq: prerequisites){
            int pre = preReq[0]; int course = preReq[1];
            grid[pre].push_back(course);
            inDegrees[course]++;
        }

        queue<int>q;
        for(int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) q.push(i);
        }

        vector<vector<bool>>isReachable(numCourses, vector<bool>(numCourses, false));
        while(!q.empty()){
            int pre = q.front();
            q.pop();

            for(auto nxt : grid[pre]){
                isReachable[pre][nxt] = true;
                for(int i = 0; i < numCourses; i++) {
                    if(isReachable[i][pre]) isReachable[i][nxt] = true;
                }

                inDegrees[nxt]--;
                if(inDegrees[nxt] == 0) q.push(nxt);
            }
        }

        vector<bool>result;

        for(auto query: queries){
            result.push_back(isReachable[query[0]][query[1]]);
        }

        return result;
        
    }
};