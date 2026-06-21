class Solution {
    public static int gcd(int a, int b) {
        // code here
        int devisor=(a>b)?b:a;
        int devident=(a>b)?a:b;
        while(devident%devisor!=0){
            int temp=devident%devisor;
            devident=devisor;
            devisor=temp;
        }
        return devisor;
    }
}
