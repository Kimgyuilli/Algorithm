import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    final static int MOD = 1000;
    static int[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        x = new int[3];
        y = new int[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long ccw = (long)(x[1] - x[0]) * (y[2] - y[0]) - (long)(x[2] - x[0]) * (y[1] - y[0]);
        if (ccw > 0) System.out.println(1);
        else if (ccw < 0) System.out.println(-1);
        else System.out.println(0);

    }
}
