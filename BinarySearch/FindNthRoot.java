// User function Template for Java

class Solution {
    public int multi(int n,int mid){
        long mul=1;
        for(int i=1;i<=n;i++){
            mul=mul*mid;
            if(mul>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int)mul;
    }
    public int nthRoot(int n, int m) {
        // code here
        int low=1;
        int high=m;
        while(low<=high){
            int mid=(low+high)/2;
            int val=multi(n,mid);
            if(val==m){
                return mid;
            }
            if(val<m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
