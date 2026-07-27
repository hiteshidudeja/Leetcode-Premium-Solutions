class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int[] right = new int[n];
        int[] left = new int[n];
        right[n - 1] = n;

        st.push(n - 1);

        for(int i = n - 2; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        left[0] = -1;
        st.push(0);

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int area = 0;

        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            area = Math.max(area, width * heights[i]);
        }

        return area;

    }
}