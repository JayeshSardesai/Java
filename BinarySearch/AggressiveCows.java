// User function Template for Java
class Solution {
    public static boolean canPlace(int[] stalls,int mid,int k){
        int count=1;
        int last=stalls[0];
        for(int i=0;i<stalls.length;i++){
            if(stalls[i]-last>=mid){
                count++;
                last=stalls[i];
            }
            if(count>=k){
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[stalls.length-1]-stalls[0];
        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(canPlace(stalls,mid,k)){
                low=mid+1;
                ans=mid;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
