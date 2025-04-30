import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            time += Integer.parseInt(st.nextToken());
        }

        time += (n-1) * 8;

        int day = time / 24;
        int hour = time % 24;

        System.out.println(day + " " + hour);

    }

}
