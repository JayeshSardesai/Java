class Solution {
    void printHollowRect(int n, int m) {
        // code here
        for(int i=0;i<n;i++){
            if(i==0||i==n-1){
                for(int j=0;j<m;j++) System.out.print("*");
            }else{
                for(int j=0;j<m;j++){
                    if(j==0||j==m-1) System.out.print("*");
                    else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
