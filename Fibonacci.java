
import java.util.*;

public class c1 {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] num = new int[n];
        num[0] = 1;
        if (n > 1) {
            num[1] = 1;
        }
        int i = 2;
        while (i < n) {
            num[i] = num[i - 1] + num[i - 2];
            i++;
        }
        System.out.println(num[n - 1]);
    }

}
