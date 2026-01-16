class Solution {
    public int beauty(String s){
        int[] temp=new int[26];
        int low=Integer.MAX_VALUE;
        int high=0;
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(temp[i]!=0&&temp[i]<low) low=temp[i];
        }
        for(int i=0;i<26;i++){
            if(temp[i]!=0&&temp[i]>high) high=temp[i];
        }
        return high-low;
    }
    public int beautySum(String s) {
        int ans=0;
        for(int i=2;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String str=s.substring(j,i+1);
                ans+=beauty(str);
            }
        }
        return ans;
    }
}
