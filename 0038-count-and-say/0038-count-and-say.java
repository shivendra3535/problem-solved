class Solution {
    public String countAndSay(int n) {
        String cas="1";
        for(int i=2; i<=n; i++){
            int cnt=1;
            StringBuilder sb= new StringBuilder();
            for(int j=1; j<cas.length(); j++){
                if(cas.charAt(j)==cas.charAt(j-1)) cnt++;
                else{
                    sb.append(cnt);
                    sb.append(cas.charAt(j-1));
                    cnt=1;
                }
            }
            sb.append(cnt);
            sb.append(cas.charAt(cas.length()-1));
            cas=sb.toString();
        }
        return cas;
    }
}