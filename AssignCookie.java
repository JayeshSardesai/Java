class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // code here
        Arrays.sort(greed);
        Arrays.sort(cookie);
        int i=0,j=0,res=0;
        while(i<greed.length&&j<cookie.length){
            if(greed[i]<=cookie[j]){
                res++;
                i++;j++;
            }else{
                j++;
            }
        }
        return res;
    }
}
