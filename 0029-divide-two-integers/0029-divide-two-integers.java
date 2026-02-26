class Solution {
    public int divide(int dividend, int divisor) {
       boolean sign=false;
       if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
       if((dividend<0 && divisor>=0) || (dividend>0 && divisor<=0)) sign=true;

       long dvd = Math.abs((long) dividend);
       long dvs = Math.abs((long) divisor);

       int sum=0;
       while(dvd>=dvs){
         int cnt=0;
         while(dvd>= dvs<<(cnt+1)){
            cnt++;
         }
         sum+=1<<cnt;
         dvd-=dvs<<(cnt);
       }
       if(sign) sum=-1*sum;
       return sum;
    }
}