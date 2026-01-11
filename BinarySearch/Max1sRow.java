// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int maxCount=-1;
        int index=-1;
        for(int i=0;i<arr.length;i++){
            int count=0;
            int low=0;
            int high=arr[0].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(arr[i][mid]==1) high=mid-1;
                else low=mid+1;
            }
            count=arr[0].length-low;
            if(count>maxCount){
                maxCount=count;
                index=i;
            }
        }
        return index;
    }
}
