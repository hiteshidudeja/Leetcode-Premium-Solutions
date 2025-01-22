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
        int i = 0; vector<Interval>temp;
        // for(auto inter: intervals) cout<<inter.start<<" "<<inter.end<<"\n";
        while(i < n){
            int f = intervals[i].start; int s = intervals[i].end;
            while(i + 1 < n && s >= intervals[i + 1].start){
                s = max(s, intervals[i+1].end);
                i++;
            };
            i++;
            temp.push_back(Interval(f, s));
        }

        // for(auto inter: temp) cout<<inter.start<<" "<<inter.end<<"\n";

        vector<Interval> result;
        for(int i = 0; i < temp.size() - 1; i++){
            result.push_back(Interval(temp[i].end, temp[i+1].start));
        }

        return result;
        
    }
};