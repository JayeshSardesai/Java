class Solution {
    public int limit(int[] weights,int mid){
        int count=0;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]<=mid){
                sum+=weights[i];
            }else{
                count++;
                sum=weights[i];
            }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(limit(weights,mid)<days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
