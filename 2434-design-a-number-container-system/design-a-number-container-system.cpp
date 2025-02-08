class NumberContainers {
private:
    unordered_map<int, int>indexToNumber;
    unordered_map<int, priority_queue<int, vector<int>, greater<int>>>numberToIndex;
public:
    NumberContainers() {
        
    }
    
    void change(int index, int number) {
        indexToNumber[index] = number;
        numberToIndex[number].push(index);
    }
    
    int find(int number) {
        if(numberToIndex.count(number) == 0) return -1;
        auto pq = numberToIndex[number];
        while(!pq.empty() && number != indexToNumber[pq.top()]){
            pq.pop();
        }

        if(pq.empty()) return -1;
        return pq.top();
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */