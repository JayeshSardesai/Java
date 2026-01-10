class Solution {
    public static int rev(int n){
        int ans=0;
        while(n>0){
            int digit = n % 10;
            n /= 10;

            // Check for overflow before updating ans
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            ans = ans * 10 + digit;
        }
        return ans;
    } 
    public int reverse(int x) {
        int ans;
        if(x>0){
            ans=rev(x);
            return ans;
        }
        else{
            ans=-rev(Math.abs(x));
            return ans;
        }
    }
}
