

// User function Template for Java

class Solution {
    static int merge(int arr[],int low,int mid,int high){
        List<Integer> li=new ArrayList<>();
        int count=0;
        int left=low;
        int right=mid+1;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                li.add(arr[left]);
                left++;
            }else{
                li.add(arr[right]);
                count+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid){
            li.add(arr[left]);
            left++;
        }
        while(right<=high){
            li.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=li.get(i-low);
        }
        return count;
        
    }
    static int mergesort(int arr[],int low,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergesort(arr,low,mid);
        count+=mergesort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int count=mergesort(arr,0,arr.length-1);
        return count;
    }
}
