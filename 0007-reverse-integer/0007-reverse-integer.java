class Solution {
    public int reverse(int x) {
        if(x<=Integer.MIN_VALUE) return 0;
        boolean neg=false;
        if(x<0){
            neg=true;
            x=-x;
        }
       int rev=0;
       while(x>0){
        if (rev > Integer.MAX_VALUE / 10 ||
            (rev == Integer.MAX_VALUE / 10 && x%10 > 7)) {
            return 0;
        }
        rev=rev*10+x%10;
        x=x/10;
       }
       if(neg){
        rev=-rev;
       }
       if(rev<=Integer.MIN_VALUE || rev>=Integer.MAX_VALUE) return 0;
       return rev;
    }
}