

// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        long s=((long)arr.length*((long)arr.length+1))/2;
        long s2=((long)arr.length*((long)arr.length+1)*(2*(long)arr.length+1))/6;
        long sn=0;
        long s2n=0;
        for(int i=0;i<arr.length;i++){
            sn+=(long)arr[i];
            s2n+=(long)arr[i]*(long)arr[i];
        }
        long val1=s-sn;
        long val2=(s2-s2n)/val1;
        long x=(val1+val2)/2;
        long y=x-val1;
        ArrayList<Integer> li=new ArrayList<>();
        li.add((int)y);
        li.add((int)x);
        return li;
    }
}
