class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            check(i,ans);
        }
        return ans;
    }
    private void check(int n,List<Integer> ans){
        int temp=n;
        while(n>0){
            int digit=n%10;
            if(digit==0||temp%digit!=0) return;
            n/=10;
        }
        ans.add(temp);
    }
}
