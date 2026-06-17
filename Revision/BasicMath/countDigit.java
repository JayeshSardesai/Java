// Count digits in the number.
class Solution {
    public static int countDigits(int n) {
        // Code here
        int cnt=0;
        while(n>0){
            n=n/10;
            cnt++;
        }
        return cnt;
    }
}


// Count digits in the number which can divide the number.
class Solution {
    public int countDigits(int num) {
        int cnt=0;
        int n=num;
        while(num>0){
            int devisor=num%10;
            if(devisor!=0&&n%devisor==0) cnt++;
            num/=10;
        }
        return cnt;
    }
}
