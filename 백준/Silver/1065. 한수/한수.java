import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(han(num));

    }

    public static int han(int num) {
        if (num < 100) {
            return num;
        } else {
            int count = 99;
            for (int i = 100; i <= num; i++) {
                int hundreds = i / 100;
                int tens = (i / 10) % 10;
                int units = i % 10;

                if ((hundreds - tens) == (tens - units)) {
                    count++;
                }
            }
            return count;

        }
    }
}
