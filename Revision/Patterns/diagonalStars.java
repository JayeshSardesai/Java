
import java.util.*;

class sam {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("No:");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print("*"); 
                }else if (i == j || i + j == n - 1) {
                    System.out.print("*"); 
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
