class Solution {
    static int evenlyDivides(int n) {
        // code here
        int i=0;
        int num=n;
        while(n>0){
            if(n%10==0){
                n=n/10;
                continue;
            }
            if(num%(n%10)==0){
                i++;
            }
            n=n/10;
        }
        return i;
    }
}
