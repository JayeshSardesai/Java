
import java.util.*;

class book {

    public int[] bookid = new int[10];
    public String[] title = new String[10];
    public String[] author = new String[10];
    public double[] price = new double[10];

    void displaydetails(int i) {
        System.out.println("Book ID: " + bookid[i]);
        System.out.println("Title: " + title[i]);
        System.out.println("Author: " + author[i]);
        System.out.println("Price: " + price[i]);
    }

    double discount(double price) {
        if (price > 200) {
            price = price * 0.20;
            return price;
        } else {
            return price;
        }
    }
}

class ebook extends book {

    float[] size = new float[10];

    void displayEdetails(int i) {

        System.out.println("Book ID: " + bookid[i]);
        System.out.println("Title: " + title[i]);
        System.out.println("Author: " + author[i]);
        System.out.println("Price: " + price[i]);
        System.out.println("Size: " + size);
    }
}

public class bookmart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Book 2.E-Book");
        System.out.println("Enter choice:");
        int choice = sc.nextInt();
        int a = 1, c = 1;
        ebook b1 = new ebook();
        book b = new book();
        switch (choice) {
            case 1:
                boolean i = true;
                while (i) {
                    sc.nextLine();
                    System.out.println("author:");
                    b.author[a] = sc.nextLine();
                    System.out.println("Price:");
                    b.price[a] = sc.nextDouble();
                    System.out.println("bookid:");
                    b.bookid[a] = sc.nextInt();
                    sc.nextLine();
                    System.out.println("title:");
                    b.title[a] = sc.nextLine();
                    b.discount(b.price[a]);
                    a++;
                    System.out.println("continue?(true/false)");
                    i = sc.nextBoolean();
                }
                break;
            case 2:
                boolean j = true;
                while (j) {
                    sc.nextLine();
                    System.out.println("title:");
                    b1.title[c] = sc.nextLine();
                    System.out.println("bookid:");
                    b1.bookid[c] = sc.nextInt();
                    System.out.println("Price:");
                    b1.price[c] = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("author:");
                    b1.author[c] = sc.nextLine();
                    b1.discount(b1.price[a]);
                    System.out.println("Enter size:");
                    b1.size[c] = sc.nextFloat();
                    c++;
                    j = sc.nextBoolean();
                }
                break;
        }
        System.out.println("1.Book 2.E-Book");
        System.out.println("Enter choice display:");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                for (int i = 1; i < a; i++) {

                    b.displaydetails(i);
                }
                break;
            case 2:
                for (int j = 1; j < c; j++) {

                    b1.displayEdetails(j);
                }
                break;
        }
    }

}
