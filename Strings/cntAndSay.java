class Solution {
    public String countAndSay(int n) {
        // code here
        if(n==1) return "1";
        String say=countAndSay(n-1);
        String ans="";
        // StringBuilder str=new StringBuilder();
        for(int i=0;i<say.length();i++){
            int cnt=1;
            char ch=say.charAt(i);
            while(i<say.length()-1&&say.charAt(i)==say.charAt(i+1)){
                cnt++;
                i++;
            }
            ans=ans+cnt+ch;
            // str.append(cnt);
            // str.append(ch);
        }
        return ans;
        // return str.toString();
    }
}
