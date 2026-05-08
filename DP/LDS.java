class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        int[] hash=new int[n+1];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int max=1;
        int last=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0&&dp[i]<1+dp[j]){
                    hash[i]=j;
                    dp[i]=1+dp[j];
                }
            }
            if(max<dp[i]){
                max=dp[i];
                last=i;
            }
        }
        List<Integer> ans=new ArrayList<>();
        ans.add(nums[last]);
        while(hash[last]!=last){
            last=hash[last];
            ans.add(nums[last]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
// Lexologically Greater
class Solution {
    
    public ArrayList<Integer> largestSubset(int[] arr) {
        
        Arrays.sort(arr);
        
        int n = arr.length;
        
        int[] dp = new int[n];
        int[] parent = new int[n];
        
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int last = 0;
        
        for(int i = 0; i < n; i++) {
            
            for(int j = 0; j < i; j++) {
                
                if(arr[i] % arr[j] == 0) {
                    
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                    
                    // same length -> choose lexicographically greater
                    else if(dp[j] + 1 == dp[i]) {
                        
                        ArrayList<Integer> a = build(j, parent, arr);
                        ArrayList<Integer> b = build(parent[i], parent, arr);
                        
                        if(greater(a, b)) {
                            parent[i] = j;
                        }
                    }
                }
            }
            
            // choose best overall subset
            if(dp[i] > dp[last]) {
                last = i;
            }
            else if(dp[i] == dp[last]) {
                
                ArrayList<Integer> a = build(i, parent, arr);
                ArrayList<Integer> b = build(last, parent, arr);
                
                if(greater(a, b)) {
                    last = i;
                }
            }
        }
        
        return build(last, parent, arr);
    }
    
    private ArrayList<Integer> build(int idx,
                                     int[] parent,
                                     int[] arr) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(parent[idx] != idx) {
            res.add(arr[idx]);
            idx = parent[idx];
        }
        
        res.add(arr[idx]);
        
        Collections.reverse(res);
        
        return res;
    }
    
    private boolean greater(ArrayList<Integer> a,
                            ArrayList<Integer> b) {
        
        int n = Math.min(a.size(), b.size());
        
        for(int i = 0; i < n; i++) {
            
            if(!a.get(i).equals(b.get(i))) {
                return a.get(i) > b.get(i);
            }
        }
        
        return a.size() > b.size();
    }
}
