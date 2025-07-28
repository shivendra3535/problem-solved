class Solution {
    public boolean check(String s, int i) {
        if (i >= s.length() / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
        return check(s, i + 1);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase(); // Convert to lowercase
        String str = s.replaceAll("[^a-zA-Z0-9]", ""); // Remove non-alphanumeric characters
        return check(str, 0);
    }
}
