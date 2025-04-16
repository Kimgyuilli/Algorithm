import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int[][] angles;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        angles = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            angles[i][0] = Integer.parseInt(st.nextToken());
            angles[i][1] = Integer.parseInt(st.nextToken());
        }

        double sum = 0;

        for (int i = 0; i<N; i++){
            sum += (double) angles[i][0] * angles[(i+1)%N][1];
            sum -= (double) angles[i][1] * angles[(i+1)%N][0];
        }

        System.out.printf("%.1f", Math.abs(sum / 2));

    }
}
