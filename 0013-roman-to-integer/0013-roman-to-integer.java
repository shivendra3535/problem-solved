class Solution {
    public int romanValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
       int sum=0;
       for(int i=0; i<s.length(); i++){
         char c=s.charAt(i);
         if(i+1<s.length() && romanValue(c)<romanValue(s.charAt(i+1))){
            sum-=romanValue(c);
         }
         else{
            sum+=romanValue(c);
         }
       }
       return sum; 
    }    
}