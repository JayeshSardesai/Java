class Solution {
    public int majorityElement(int[] nums) {
        int count=0,ans=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                ans=nums[i];
            }
            count+=(nums[i]==ans)?1:-1;
        }
        return ans;
    }
}
