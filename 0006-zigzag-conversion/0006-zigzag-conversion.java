class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int numCols = s.length();
        char[][] ch = new char[numRows][numCols];

        int i = 0;
        int j = 0;
        int c = 0;

        while (c < s.length()) {
            while (i < numRows && c < s.length()) {
                ch[i][j] = s.charAt(c++);
                i++;
            }
            i -= 2;
            j = j + 1;
            while (i > 0 && c < s.length()) {   
                ch[i][j] = s.charAt(c++);
                i--;
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (i = 0; i < numRows; i++) {
            for (j = 0; j < numCols; j++) {
                if (ch[i][j] != '\0') {
                    sb.append(ch[i][j]);
                }
            }
        }

        return sb.toString();
    }
}