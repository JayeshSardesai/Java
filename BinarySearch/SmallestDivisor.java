class Solution {
    public int sum(int[] nums,int mid){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Arrays.stream(nums).max().getAsInt();
        int min=1;
        while(low<=high){
            int mid=(low+high)/2;
            int sum=sum(nums,mid);
            if(sum<=threshold){
                min=mid;    
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return min;
    }
}
