class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                num[k++]=nums1[i++];
            }
            else{
                num[k++]=nums2[j++];
            }
        }
        while(i<m){
            num[k++]=nums1[i++];
        }
        while(j<n){
            num[k++]=nums2[j++];
        }
        for(int l=0;l<m+n;l++){
            nums1[l]=num[l];
        }
    }
}
