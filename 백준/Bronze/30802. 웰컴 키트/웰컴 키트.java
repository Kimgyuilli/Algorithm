import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int N, T, P, Tcount = 0;
        int[] list = new int[6];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 6; i++) {
            Tcount += (list[i] + T - 1) / T;  // 올림 계산
        }

        System.out.println(Tcount);
        System.out.println((N /P) + " " + (N % P));



    }
}