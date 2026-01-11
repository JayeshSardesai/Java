class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                ans[0]=mid;
            }
            if(target<=nums[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        low=0;
        mid=0;
        high=nums.length-1;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                ans[1]=mid;
            }
            if(target>=nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
