class StockSpanner {
    Stack<Integer> st;
    List<Integer> prices;
    int i=0;
    public StockSpanner() {
        st= new Stack<>();
        prices= new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(i,price);
        while(!st.isEmpty() && prices.get(st.peek())<=price){
            st.pop();
        }
        int a= st.isEmpty() ? -1 : st.peek();
        st.push(i++);
        return i-a-1; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */