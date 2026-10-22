class MedianFinder {


    // MIN, max heap
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int num) {
        // 
        max.offer(num);
        min.offer(max.poll());

        if(min.size() > max.size()) max.offer(min.poll());

        return;
    }
    
    public double findMedian() {
        return max.size() > min.size() ? max.peek() : (min.peek() + max.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */