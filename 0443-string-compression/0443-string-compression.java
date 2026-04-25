class Solution {
    public int compress(char[] chars) {
        int index=0;
        int i=0;
        while(i<chars.length){
            chars[index++]=chars[i];
            int j=i+1;
            int cnt=1;
            while(j<chars.length && chars[j]==chars[j-1]){
                cnt++;
                j++;
            }
            if(cnt>1){
                for(char c: Integer.toString(cnt).toCharArray()){
                    chars[index++]=c;
                }
            }
            i=j;
        }
        return index;
    }
}