class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = nums.length;
        for(int i = 0; i < k ; i++) {
            minHeap.offer(nums[i]);
        }

        for(int j = k; j < n; j++){
            if(nums[j] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[j]);
            }
        }

        return minHeap.peek();
    }
}