//O(n^2) time complexity for worst case.
class Solution {
    public int jump(int[] nums) {
        int jumps=0,r=0,l=0;
        while(r<nums.length-1){
            int far=0;
            for(int i=l;i<=r;i++){
                far=Math.max(i+nums[i],far);
            }
            l=r+1;
            r=far;
            jumps++;
        }
        return jumps;
    }
}

//O(n) time complexity.
class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n=arr.length;
        if(arr[0]==0) return -1;
        if(n<=1) return 0;
        int jumps=0,r=0,far=0;
        for(int i=0;i<n-1;i++){
            far=Math.max(far,i+arr[i]);
            if(i==r){
                jumps++;
                if(far<=i) return -1;
                r=far;
            }
        }
        return jumps;
    }
}
