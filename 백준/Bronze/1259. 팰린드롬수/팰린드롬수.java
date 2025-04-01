import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.next();
            if (s.equals("0")) break;

            String reversed = new StringBuilder(s).reverse().toString();
            if (s.equals(reversed)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
