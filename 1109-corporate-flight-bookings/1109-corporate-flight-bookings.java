class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int answer[]= new int[n];
        for(int booking[]: bookings){
            int first=booking[0];
            int last=booking[1];
            int seats=booking[2];
            for(int i=first; i<=last; i++){
                answer[i-1]+=seats;
            }
        }
        return answer;
    }
}