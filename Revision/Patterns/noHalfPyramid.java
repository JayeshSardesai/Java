1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

// Printing the exact half pyramid

import java.util.*;

class sam {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int no = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + no++);
            }
            System.out.println();
        }
    }
}
