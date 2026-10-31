class Solution {
    class Pair{
        int pos;
        int speed;
        Pair(int pos, int speed){
            this.pos=pos;
            this.speed=speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair arr[]= new Pair[position.length];
        for(int i=0; i<position.length; i++){
            arr[i]= new Pair(position[i],speed[i]);
        }
        Arrays.sort(arr,(a,b)->b.pos-a.pos);
        Stack<Double> st= new Stack<>();
        for(Pair p: arr){
            int pos=p.pos;
            int sp=p.speed;
            double time = (double)(target - pos) / sp;
            if(st.isEmpty() || time > st.peek()) st.push(time);
        }
        return st.size();
    }
}