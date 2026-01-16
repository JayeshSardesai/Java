class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        int m=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            m=Math.min(m,strs[i].length());
        }
        for(int i=0;i<m;i++){
            int j=0;
            while(j<strs.length){
                if(strs[0].charAt(i)==strs[j].charAt(i)){
                    j++;
                    continue;
                }
                return ans;
            }
            if(j==strs.length){
                ans+=strs[0].charAt(i);
            }
        }
        return ans;
    }
}
