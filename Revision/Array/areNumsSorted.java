// So in this we have sentence in which we have numbers that numbers should in sored manner.
class Solution {
    public boolean areNumbersAscending(String s) {
        int recent = -1;
        int prev = -2;
        int drop = 0;
        int n = s.length();
        int i = 0;
        while(i < n) {
            int digit = s.charAt(i) - '0';
            if (digit <= 9 && digit >= 0){
                prev = recent;
                recent = digit;
                i++;
                while (i < n && s.charAt(i) != ' '){
                    recent = (recent * 10) + (s.charAt(i) - '0');
                    i++;
                }
            }
            if (prev >= recent) {
                drop++;
            }
            i++;
        }
        return drop == 0;
    }
}
