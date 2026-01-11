class Solution {
    public int noStudents(int[] nums,int mid,int k){
        int count=1,work=0;
        for(int i=0;i<nums.length;i++){
            if(work+nums[i]<=mid){
                work+=nums[i];
            }else{
                count++;
                work=nums[i];
            }
        }
        return count;
    }
    public int find(int[] nums,int k){
        if(nums.length<k) return -1;
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int count=noStudents(nums,mid,k);
            if(count>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int splitArray(int[] nums, int k) {
        return find(nums,k);
    }
}
