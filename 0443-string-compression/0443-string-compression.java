class Solution {
    public int compress(char[] chars) {
       int i=0;
       List<Character> list= new ArrayList<>();
       while(i<chars.length){
         list.add(chars[i]);
         int cnt=1;
         int j=i+1;
         while(j<chars.length && chars[j]==chars[j-1]){
            cnt++;
            j++;
         }

         if(cnt>1) {
            for (char c : String.valueOf(cnt).toCharArray()) {
                list.add(c);
            }
        }
         i=j;
       }
       for (int k = 0; k < list.size(); k++) {
            chars[k] = list.get(k);
        }

        return list.size();

    }
} 