class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;

        s = s.trim();
        if (s.length() == 0) return 0; // Handle case where string is only spaces

        int sign = 1, ans = 0, i = 0;
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        // Handle sign
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow **before** updating ans
            if (ans > (max / 10) || (ans == (max / 10) && digit > (max % 10))) {
                return sign == 1 ? max : min;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return sign * ans;
    }
}
