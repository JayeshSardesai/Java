class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr=new int[nums.length];
        int j=0;
        k=k%nums.length;
        if(nums.length==k||nums.length==1){
            return;
        }
        for(int i=Math.abs(nums.length-k)%nums.length;(i%nums.length)!=Math.abs(nums.length-k-1);i++){
            arr[j++]=nums[i%nums.length];
        }
        arr[j]=nums[nums.length-k-1];
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}
