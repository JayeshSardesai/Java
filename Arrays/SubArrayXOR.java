

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> hash=new HashMap<>();
        int count=0;
        int xr=0;
        hash.put(0,1);
        for(int i=0;i<arr.length;i++){
            xr=xr^arr[i];
            int rem=xr^k;
            count+=hash.getOrDefault(rem,0);
            hash.put(xr,hash.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
