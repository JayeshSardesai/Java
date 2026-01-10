

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int longest=1;
        if(arr.length==0)
            return 0;
        if(arr.length==1) 
            return 1;
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            st.add(arr[i]);
        }
        for(int it:st){
            if(!st.contains(it-1)){
                int count=1;
                int x=it;
                while(st.contains(x+1)){
                    x++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}
