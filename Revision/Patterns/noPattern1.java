1        1
12      21
123    321
1234  4321
1234554321

// Printing given pattern

import java.util.*;

class sam {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("No:");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            for (int j = 0; j < (n - i - 1) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = i + 1; j > 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
