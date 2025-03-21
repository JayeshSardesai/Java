class Solution {
    int missingNumber(int arr[]) {
        // code here
        Arrays.sort(arr);
        if(arr.length==1){
            if(arr[0]==1){
                return 2;
            }
        }
        int i;
        for(i=1;i<arr[arr.length-1];i++){
            if(i!=arr[i-1]){
                return i;
            }
        }
        return i+1;
    }
}
