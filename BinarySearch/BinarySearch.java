class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                break;
            }
            if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
