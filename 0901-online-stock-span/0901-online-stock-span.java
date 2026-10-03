class StockSpanner {
    List<Integer> prices;
    Stack<Integer> st;
    public StockSpanner() {
        prices=new ArrayList<>();
        st=new Stack<>();
    }
    
    public int next(int price) {
        prices.add(price);
        while(!st.isEmpty() && price>=prices.get(st.peek())){
            st.pop();
        }
        int prev= st.isEmpty()?-1 : st.peek();
        st.push(prices.size()-1);
        return (prices.size()-1)-prev;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */