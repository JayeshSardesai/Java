class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==0){
                for(int j=i;j<n-1;j++){
                    nums[j]=nums[j+1];
                }
                n--;
                nums[n]=0;
            }else{
                i++;
            }
        }
    }
}
