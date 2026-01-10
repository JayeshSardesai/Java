class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        int i=arr.length-1;
        int max=0;
        while(i>=0){
            if(arr[i]>=max){
                max=arr[i];
                li.add(0,arr[i]);
            }
            i--;
        }
        return li;
    }
}
