
// public class c {
//     public static void main(String[] args) {
//         try {
//             String str = null;
//             System.out.println(str.length());
//         } catch (Exception e) {
//             System.out.println("ERROR:Null pointer exception");
//         }
//     }
// }
// public class c {
//     public static void main(String[] args) {
//         String str = null;
//         int[] a = new int[]{2, 3, 4};
//         try {
//             System.out.println(str.length());
//             System.out.println(a[4]);
//         } catch (ArrayIndexOutOfBoundsException e) {
//             System.out.println("ERROR" + e);
//         } catch (NullPointerException g) {
//             System.out.println("ERROR" + g);
//         }
//     }
// }
// import java.util.Scanner;
// public class c {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         try {
//             System.out.println("Interger:");
//             int a = sc.nextInt();
//         } catch (Exception e) {
//             System.out.println("ERROR" + e);
//         }
//     }
// }
// import java.util.Scanner;
// public class c {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         try {
//             System.out.println("Interger:");
//             int a = sc.nextInt();
//             throw new Exception("Invalid input");
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }
public class c {

    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i == 5) {
                        Thread.sleep(5000);
                        }
                        System.out.println(i);
                    }
                } catch (Exception e) {
                    System.out.println("Thread was Interrupted.");
                }
            }
        });
        th.start();
        th.interrupt();

    }
}
