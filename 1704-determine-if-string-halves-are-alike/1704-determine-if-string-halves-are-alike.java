class Solution {
    public int cntVowel(String s){
        int cnt=0;
        for(char c: s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='I' || c=='O' || c=='E' || c=='U'){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        String a=s.substring(0,(n/2));
        String b=s.substring((n/2),n);
        return cntVowel(a)==cntVowel(b);
    }
}