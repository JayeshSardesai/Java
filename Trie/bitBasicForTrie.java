// User function Template for Java

class Solution {

    public int XOR(int n, int m) {
        // Code here
        return n^m;
    }

    public int check(int a, int b) {
        // Code here
        return (((1<<(a-1))&b)!=0)?1:0;
    }

        
    public int setBit(int c, int d) {
        // Code here
        return ((1<<c)|d);
    }
}
