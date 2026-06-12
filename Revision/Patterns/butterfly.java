import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        for(int i=0;i<n-1;i++){
            for(int j=0;j<=i;j++) System.out.print("*");
            for(int j=0;j<((n-2-i)*2)+1;j++) System.out.print(" ");
            for(int j=0;j<=i;j++) System.out.print("*");
            System.out.println();
        }
        for(int i=0;i<2*n-1;i++) System.out.print("*");
        System.out.println();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++) System.out.print("*");
            for(int j=0;j<((n-2-i)*2)+1;j++) System.out.print(" ");
            for(int j=0;j<=i;j++) System.out.print("*");
            System.out.println();
        }
        

        sc.close();
    }
}
