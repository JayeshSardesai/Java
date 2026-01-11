
//Back-end complete function Template for Java
import java.util.*;
class Solution {
    public static int function(int[] arr,int mid){
        int count=1,pages=0;
        for(int i=0;i<arr.length;i++){
            if(pages+arr[i]<=mid){
                pages+=arr[i];
            }else{
                count++;
                pages=arr[i];
            }
        }
        return count;
    }
    public static int findPages(int[] arr, int k) {
        // code here
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        if(arr.length<k){
            return -1;
        }
        while(low<=high){
            int mid=(low+high)/2;
            int count=function(arr,mid);
            if(count>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}
