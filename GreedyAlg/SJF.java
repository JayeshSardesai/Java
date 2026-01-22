// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        int n=bt.length;
        int wttime=0;
        int avgwttime=0;
        Arrays.sort(bt);
        for(int i=0;i<n-1;i++){
            wttime+=bt[i];
            avgwttime+=wttime;
        }
        return avgwttime/n;
    }
}
