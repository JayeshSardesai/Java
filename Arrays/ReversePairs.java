class Solution {
    public void merge(int arr[],int low,int mid,int high){
        int left=low;
        int right=mid+1;
        List<Integer> li=new ArrayList<>();
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                li.add(arr[left++]);
            }else{
                li.add(arr[right++]);
            }
        }
        while(left<=mid){
            li.add(arr[left++]);
        }
        while(right<=high){
            li.add(arr[right++]);
        }
        for(int i=low;i<=high;i++){
            arr[i]=li.get(i-low);
        }
    }
    public int mergesort(int arr[],int low,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergesort(arr,low,mid);
        count+=mergesort(arr,mid+1,high);
        count+=countNo(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }
    public int countNo(int arr[],int low,int mid,int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high&&(long)arr[i]>2L*arr[right]) right++;
            count+=(right-(mid+1));
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        int count=mergesort(nums,0,nums.length-1);
        return count;
    }
}
