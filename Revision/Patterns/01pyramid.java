import java.util.*;

class sam {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("No:");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int no = 1;
                for (int j = 0; j <= i; j++) {
                    System.out.print(no);
                    no = Math.abs(no - 1);
                }
            } else {
                int no = 0;
                for (int j = 0; j <= i; j++) {
                    System.out.print(no);
                    no = Math.abs(no - 1);
                }

            }
            System.out.println();
        }
    }
}
