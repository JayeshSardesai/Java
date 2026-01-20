class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int cnt=1;
        int res=1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0,n=arr.length;
        while(i<n){
            if(arr[i]<=dep[j]){
                cnt++;
                res=Math.max(res,cnt);
                i++;
            }else{
                cnt--;
                res=Math.max(res,cnt);
                j++;
            }
        }
        return res;
    }
}
