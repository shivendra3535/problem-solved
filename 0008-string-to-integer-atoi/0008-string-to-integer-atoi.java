class Solution {
    public int myAtoi(String s) {
        int i=0;
        long nums=0;
        int sign=1;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        while(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if(i>0 && (s.charAt(i-1)=='+' || s.charAt(i-1)=='-')) return 0;
            if(s.charAt(i)=='-') sign=-1;
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            nums= nums*10 + s.charAt(i)-'0';

            if(sign==1 && nums>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign==-1 && nums>Integer.MAX_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return sign*(int)nums;
    }
}