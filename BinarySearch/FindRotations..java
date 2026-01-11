

// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int low=0;
        int high=arr.size()-1;
        int ans=Integer.MAX_VALUE;
        int i=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(low)<=arr.get(high)){
                if(arr.get(low)<ans){
                    ans=arr.get(low);
                    i=low;
                }
                break;
            }
            if(arr.get(low)<=arr.get(mid)){
                if(arr.get(low)<ans){
                    ans=arr.get(low);
                    i=low;
                }
                low=mid+1;
            }else{
                if(arr.get(mid)<ans){
                    i=mid;
                    ans=arr.get(mid);
                }
                high=mid-1;
            }
        }
        return i;
    }
}
