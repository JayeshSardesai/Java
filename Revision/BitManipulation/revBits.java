class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int i=31;
        while(i>=0){
            int check=(1<<i)&n;
            if(check!=0) ans=ans^(1<<(31-i));
            i--;
        }
        return ans;
    }
}
