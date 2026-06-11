A
A B
A B C
A B C D
A B C D E

// Printing Alphabet Half Pyramid

import java.util.*;

class sam {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("No:");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char no = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + no++);
            }
            System.out.println();
        }
    }
}
