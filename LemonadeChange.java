class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int five=0,ten=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==5){
                five++;
                continue;
            }
            if(arr[i]==10){
                if(five>=1){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }
            if(arr[i]==20){
                if(five>=1&&ten>=1){
                    five--;
                    ten--;
                }else if(five>=3){
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
