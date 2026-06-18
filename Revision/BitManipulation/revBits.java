// This will work for the bits exactly 32. But not for the user defined digits means if it 11 then only 4 digits not 32 digits.
class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int i=31;
        while(i>=0){
            int check=(1<<i)&n;
            if(check!=0) ans=ans^(1<<(31-i));
            i--;
        }
        return ans;
    }
}

class Solution {
    public int reverseBits(int n) {
        // code here
        int ans=0;
        int valid=0;
        int i=0;
        while(i<32){
            int check=(1<<i)&n;
            if(check!=0) valid=valid^(1<<i);
            if(check!=0) ans=(ans<<1)^1;
            else ans=ans<<1;
            i++;
        }
        return ans;
    }
}

/* This program is for the dynamic number of bits means leading zeros are trailed to convert it to 32 bit just change the condition in while as while(i<32)
   then it will reverse the 32 bit integer also.
*/
class Solution {
    public int reverseBits(int n) {
        // code here
        int ans=0;
        int valid=0;
        int i=0;
        while(valid!=n){
            int check=(1<<i)&n;
            if(check!=0) valid=valid^(1<<i);
            if(check!=0) ans=(ans<<1)^1;
            else ans=ans<<1;
            i++;
        }
        return ans;
    }
}
