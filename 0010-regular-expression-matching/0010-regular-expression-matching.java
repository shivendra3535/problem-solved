
class Solution {
    public boolean memo(String s, String p, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;

        if (i < 0) {
            if (p.charAt(j) == '*') {
                return memo(s, p, i, j - 2);
            }
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return memo(s, p, i - 1, j - 1);
        } 
        else if (p.charAt(j) == '*') {
            if (p.charAt(j - 1) == s.charAt(i) ||
                p.charAt(j - 1) == '.') {
                return memo(s, p, i, j - 2) ||
                       memo(s, p, i - 1, j);
            }
            return memo(s, p, i, j - 2);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        return memo(s, p, s.length() - 1, p.length() - 1);
    }
}
