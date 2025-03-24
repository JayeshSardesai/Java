class Solution {
    static long factorial(long n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> ans=new ArrayList<>();
        if(n==1){
            ans.add((long)(1));
            return ans;
        }
        long i=1;
        while(factorial(i)<=n){
            ans.add(factorial(i));
            i++;
        }
        return ans;
    }
}
