import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            double sum = 0f;
            int[] scores = new int[n];
            for(int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }

            double avg = sum / n;
            int count = 0;

            for(int s : scores) {
                if(s > avg) count++;
            }

            System.out.printf("%.3f", count * 100f / n);
            System.out.println("%");
        }

    }






}