class RangeModule {
private:
    map<int, int>mp;
    static constexpr int inf = 1e9 + 10;
public:
    RangeModule() {
        mp[-1] = -1;
        mp[inf] = inf;
    }

    void print() {
        for(auto x : mp){
            cout << x.first << ' ' << x.second << "\n";
        }

        cout << "\n";
    }


    void partition(int x){
        auto it = mp.lower_bound(x);
        --it;
        if(it->second < x) return;
        mp[x] = it->second;
        it->second = x - 1;

    }
    
    void addRange(int left, int right) {
        removeRange(left, right);

        --right;

        auto it = mp.emplace(left, right).first;
        
        for(int _ = 0; _ < 2; ++_){
            auto it_prev = prev(it);
            if(it_prev->second + 1 >= it->first){
                it_prev->second = it->second;
                it = mp.erase(it);
            }else{
                ++it;
            }
        }

    }
    
    bool queryRange(int left, int right) {
        // print();
        --right;
        auto it = prev(mp.upper_bound(left));
        return it->second >= right;
    }
    
    void removeRange(int left, int right) {
        --right;

        partition(left);
        partition(right + 1);

        auto it = mp.lower_bound(left);
        while(it->first <= right){
            it = mp.erase(it);
        }


    }
};

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule* obj = new RangeModule();
 * obj->addRange(left,right);
 * bool param_2 = obj->queryRange(left,right);
 * obj->removeRange(left,right);
 */