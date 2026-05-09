class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(checkPos(words[i],words[j])&&dp[i]<1+dp[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    private boolean checkPos(String s1,String s2){
        if(s1.length()!=s2.length()+1) return false;
        int f=0,s=0;
        while(f!=s1.length()){
            if(s<s2.length()&&s1.charAt(f)==s2.charAt(s)){
                f++;s++;
            }else{
                f++;
            }
        }
        if(f==s1.length()&&s==s2.length()) return true;
        return false;
    }
}

// Optimized Approach.
class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = 1;
        for (String word : words) {
            int best = 1;
            for (int i = 0; i < word.length(); i++) {
                String prev =
                    word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best,
                        dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}
