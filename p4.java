
public class p4 {

    public static String zigzag(String s, int n) {
        if (n == 1) {
            return s;
        }
        int i = 0, j = 0, k = 0, l = 0;
        String str = "";
        char[][] arr = new char[n][s.length()];
        while (j < s.length() && k < s.length()) {
            if (l == 0) {
                while (i < n) {
                    arr[i][j] = s.charAt(k);
                    i++;
                    k++;
                }
                l++;
            } else {
                arr[(n - 1) - l][j] = s.charAt(k);
                k++;
                l++;
                if (l == (n - 1)) {
                    l = 0;
                }
            }
            j++;
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < s.length(); y++) {
                if (arr[x][y] != '\0') {
                    System.out.println(arr[x][y]);
                    str += arr[x][y];
                }
            }
            System.out.println("\n");
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int n = 3;
        String str = zigzag(s, n);
        System.out.println(str);
    }
}
