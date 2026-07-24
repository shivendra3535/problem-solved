class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;

        while (i < chars.length) {
            char curr = chars[i];
            int j = i + 1;
            int cnt = 1;

            while (j < chars.length && chars[j] == curr) {
                cnt++;
                j++;
            }

            
            chars[index++] = curr;

            
            if (cnt > 1) {
                String s = String.valueOf(cnt);
                for (char c : s.toCharArray()) {
                    chars[index++] = c;
                }
            }

            i = j;
        }

        return index;
    }
}