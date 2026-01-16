class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> v=new HashMap<>();
        v.put('I',1);
        v.put('V',5);
        v.put('X',10);
        v.put('L',50);
        v.put('C',100);
        v.put('D',500);
        v.put('M',1000);
        int ans=0,i=0;
        while(i<s.length()-1){
            if(v.get(s.charAt(i))<v.get(s.charAt(i+1))){
                ans=ans+(v.get(s.charAt(i+1))-v.get(s.charAt(i)));
                i+=2;
            }else{
                ans+=v.get(s.charAt(i));
                i++;
            }
        }
        if(i==s.length()-1) ans+=v.get(s.charAt(i));
        return ans;
    }
}
