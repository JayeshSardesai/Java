// User function Template for Java

class Solution {
    static int noPainter(int[] arr,int mid){
        int count=1,work=0;
        for(int i=0;i<arr.length;i++){
            if(work+arr[i]<=mid){
                work+=arr[i];
            }else{
                count++;
                work=arr[i];
            }
        }return count;
    }
    static int find(int[] arr,int k){
        // if(arr.length<k) return -1;
        int low=Arrays.stream(arr).max().getAsInt();
        int high=Arrays.stream(arr).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int count=noPainter(arr,mid);
            if(count>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int minTime(int[] arr, int k) {
        // code here
        return find(arr,k);
    }
}
