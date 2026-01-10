
import java.util.Scanner;

class c1 {

    public static boolean armstrong(int num) {
        char[] number = String.valueOf(num).toCharArray();
        int n = number.length;
        int a = num;
        int ans = 0;
        while (num > 0) {
            int digit = num % 10;
            ans = ans + (int) (Math.pow(digit, n));
            num /= 10;
        }
        if (ans != a) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean pali = armstrong(num);
        System.out.println(pali);
    }
}
