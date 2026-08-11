class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {
        st.push(value);

        if (min.isEmpty() || value <= min.peek()) {
            min.push(value);
        }
    }

    public void pop() {
        int val = st.pop();

        if (val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}