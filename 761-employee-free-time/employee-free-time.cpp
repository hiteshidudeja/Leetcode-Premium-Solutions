/*
// Definition for an Interval.
class Interval {
public:
    int start;
    int end;

    Interval() {}

    Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
public:
    static bool comp(Interval a, Interval b){
        if(a.start == b.start) return a.end < b.end;
        return a.start < b.start;
    }
    vector<Interval> employeeFreeTime(vector<vector<Interval>> schedule) {
        // [[]]
        // intervals - [[1 3] [6 7] [2 4] [2 5] [9 12]]
        // find the free time -> gaps b/w intervals 
        // merge intervals && then find the free time
        // step 1 : merge intervals

        vector<Interval>intervals;
        for(auto sch: schedule){
            for(auto inter: sch) intervals.push_back(inter);
        }

        sort(intervals.begin(), intervals.end(), comp);
        int n = intervals.size();
        vector<Interval>result;
        // for(auto inter: intervals) cout<<inter.start<<" "<<inter.end<<"\n";
        int s = intervals[0].end;
        for(int i = 1; i < n; i++){
            if(s < intervals[i].start){
                result.push_back(Interval(s, intervals[i].start));
            }

            s = max(s, intervals[i].end);
        }

        // for(auto inter: temp) cout<<inter.start<<" "<<inter.end<<"\n";

        return result;
        
    }
};