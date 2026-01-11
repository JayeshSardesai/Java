

class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int ans=0;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=target){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans+1;
    }
}
