import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < T; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if(cur + sum < cur) sum = cur;
            else sum += cur;

            if(sum > max) max = sum;
        }
        System.out.println(max);
    }
}