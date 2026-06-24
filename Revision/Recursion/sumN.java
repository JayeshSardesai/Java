import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        int noSum=sum(n);
        System.out.print(noSum);
    }
    private static int sum(int n){
        if(n<=0) return 0;
        return n+sum(n-1);
    }
}
