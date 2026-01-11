// User function Template for Java

class Solution {
    int nos(int[] mat,int x){
        int low=0,high=mat.length-1;
        int ans=mat.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid]>x){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    int black(int[][] mat,int x){
        int count=0;
        for(int i=0;i<mat.length;i++){
            count+=nos(mat[i],x);
        }
        return count;
    }
    int median(int mat[][]) {
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][mat[0].length-1]);
        }
        while(low<=high){
            int mid=(low+high)/2;
            int minNos=black(mat,mid);
            int req=((mat.length)*(mat[0].length))/2;
            if(minNos<=req) low=mid+1;
            else high=mid-1;
            
        }
        return low;
    }
}
