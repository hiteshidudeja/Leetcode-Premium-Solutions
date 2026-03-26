class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 
        Map<Integer, Integer> map = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums2.length;
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());

            stack.push(nums2[i]);
        }

        int[] answer = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            answer[i] = map.get(nums1[i]);
        }

        return answer;

    }
}