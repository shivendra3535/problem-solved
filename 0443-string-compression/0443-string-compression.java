class Solution {
    public int compress(char[] chars) {
       int i=0;
       int index=0;
       while(i<chars.length){
         chars[index++]=chars[i];
         int cnt=1;
         int j=i+1;
         while(j<chars.length && chars[j]==chars[j-1]){
            cnt++;
            j++;
         }

         if(cnt>1) {
            for (char c : String.valueOf(cnt).toCharArray()) {
                chars[index++]=c;
            }
        }
         i=j;
       }
       return index;
    }
} 