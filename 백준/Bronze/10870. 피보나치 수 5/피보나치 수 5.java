import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n < 2) {
            System.out.println(n);
            return;
        }

        int pre = 0;
        int cur = 1;

        for(int i = 2; i <= n; i++) {
            int temp = pre + cur;
            pre = cur;
            cur = temp;
        }

        System.out.println(cur);
    }
}