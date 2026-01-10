class Solution {
    public int findMin(int n) {
        // code here
        int[] coins=new int[]{1,2,5,10};
        int i=3;
        int res=0;
        while(i>=0){
            if(coins[i]<=n){
                n=n-coins[i];
                res++;
            }else{
                i--;
            }
        }
        return res;
    }
}
