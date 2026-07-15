class Solution {
    public char findTheDifference(String s, String t) {
        char sXr = 0x0;
        char tXr = 0x0;
        for (int i = 0; i < s.length();i++) {
            sXr ^= (s.charAt(i));
            tXr ^= (t.charAt(i));
        }
        tXr ^= (t.charAt(t.length() - 1));
        return ((char)(sXr ^ tXr));
    }
}
