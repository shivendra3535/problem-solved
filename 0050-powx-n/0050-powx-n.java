class Solution {
    public double pow(double x, int n){
        if(n==0) return 1.0;

        double half=pow(x,n/2);
        if(n%2==0) return half*half;
        else return x*half*half;
    }
    public double myPow(double x, int n) {
        int N=n;
        if(N<0) N=-1*N;
        double p=pow(x,N);
        if(n<0){
            return 1/p;
        }
        return p;
    }
}