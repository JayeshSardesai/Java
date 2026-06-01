class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        String s=pat+'$'+txt;
        int[] z=zArray(s);
        int m=pat.length();
        int n=z.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=m+1;i<n;i++){
            if(z[i]==m) ans.add(i-m-1);
        }
        return ans;
    }
    int[] zArray(String s){
        int n=s.length();
        int[] z=new int[n];
        int l=0,r=0;
        for(int i=1;i<n;i++){
            if(i<=r){
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            while(i+z[i]<n&&s.charAt(z[i])==s.charAt(i+z[i])){
                z[i]++;
            }
            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }
}
