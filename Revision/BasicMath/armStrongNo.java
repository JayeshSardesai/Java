class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int temp=n;
        int armNo=0;
        while(n>0){
            int digit=n%10;
            armNo=armNo+(digit*digit*digit);
            n/=10;
        }
        return temp==armNo;
    }
}
