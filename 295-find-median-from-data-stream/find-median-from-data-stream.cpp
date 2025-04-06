class MedianFinder {
public:
    priority_queue<double>max_heap;
    priority_queue<double, vector<double>, greater<double>>min_heap;
    double median;

    MedianFinder() {
    }
    
    void addNum(int num) {
       if(max_heap.empty() && min_heap.empty()){
            max_heap.push(num); median = num; return;
       }


       if(max_heap.size() == min_heap.size()){
            if(num > median) {
                min_heap.push(num); median = min_heap.top();
            }
            else {
                max_heap.push(num); median = max_heap.top();
            }
       }

       else if(max_heap.size() > min_heap.size()){
            if(num > median) {
                min_heap.push(num); 
            } else {
                int element = max_heap.top(); max_heap.pop(); min_heap.push(element);
                max_heap.push(num); 
            }

            median = (min_heap.top() + max_heap.top())/2;
       }

       else {
            if(num < median){
                max_heap.push(num); 
            } else {
                int element = min_heap.top(); min_heap.pop(); max_heap.push(element);
                min_heap.push(num); 
            }

            median = (min_heap.top() + max_heap.top())/2;
       }

       return;
    } 
    
    double findMedian() {
        return median;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */