

// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> hash=new HashMap<>();
        int max=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                max=Math.max(max,i+1);
            }
            if(!hash.containsKey(sum)){
                hash.put(sum,i);
            }
            
            if(hash.containsKey(sum-k))
            {
                max=Math.max(max,i-hash.get(sum-k));
            }
        }
        return max;
    }
}
