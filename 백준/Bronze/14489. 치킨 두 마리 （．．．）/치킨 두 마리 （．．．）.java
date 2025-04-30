import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int chic = Integer.parseInt(br.readLine());

        if(n + m >= chic * 2) {
            System.out.println((n + m) - chic*2);
        } else {
            System.out.println(n + m);
        }
    }

}
