class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>(); 
        int n = nums.length;


        int[] result = new int[n - k + 1];

        int i = 0;  int idx = 0;

        for(int j = 0; j < n; j++){
            while(!d.isEmpty() && nums[j] > nums[d.getLast()]) d.removeLast();
            d.addLast(j);

            if(j - i + 1 == k){
                result[idx] = nums[d.getFirst()]; idx++;
                i++;
                if(d.getFirst() < i) {
                    d.removeFirst();
                }
            }
        }

        return result;
    }
}