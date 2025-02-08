class NumberContainers {
private:
    unordered_map<int, int>numberAtIndex;
    unordered_map<int, set<int>>numberToIndexMap;
public:
    NumberContainers() {
    }
    
    void change(int index, int number) {
        if(numberAtIndex.count(index)){
            int previousNumber = numberAtIndex[index];
            numberToIndexMap[previousNumber].erase(index);
            if(numberToIndexMap[previousNumber].empty()) numberToIndexMap.erase(previousNumber);
        }
        numberAtIndex[index] = number;
        numberToIndexMap[number].insert(index);
    }
    
    int find(int number) {
        if(numberToIndexMap.count(number) == 0) return -1;
        return *numberToIndexMap[number].begin();
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */