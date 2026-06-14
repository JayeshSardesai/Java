import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int val=Math.min(Math.min(Math.abs(0-i),Math.abs(0-j)),
                Math.min(Math.abs(2*n-2-i),Math.abs(2*n-2-j)));
                System.out.print(Math.abs(n-val)+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
