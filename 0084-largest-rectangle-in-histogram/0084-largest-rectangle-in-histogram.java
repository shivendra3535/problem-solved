class Solution {
    public int[] nextSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ans;
    }

    public int[] prevSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = prevSmaller(heights);

        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            int width = next[i] - prev[i] - 1;

            int area = heights[i] * width;

            max = Math.max(max, area);
        }

        return max;
    }
}