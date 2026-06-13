3 3 3 2 2 2 1 1 1
3 3 2 2 1 1 
3 2 1

// Printing the above pattern.
class Solution {
    public ArrayList<Integer> printPat(int n) {
        // write code here
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            for(int j=n;j>=1;j--){
                for(int k=0;k<=i;k++){
                    ans.add(j);
                }
            }
            ans.add(-1);
        }
        return ans;
    }
}
