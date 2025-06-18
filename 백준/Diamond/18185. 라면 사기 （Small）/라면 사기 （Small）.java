import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] factory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        factory = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        int money = 0;
        int i = 0;

        while (i < N) {

            // i+1 > i+2 인 경우 : 2개 묶음(i, i+1)을 먼저 구매 (반례 방지)
            if (factory[i + 1] > factory[i + 2]) {
                int buyCount = Math.min(factory[i], factory[i + 1] - factory[i + 2]);
                money += buyCount * 5;
                factory[i] -= buyCount;
                factory[i + 1] -= buyCount;
            }

            // 3개 묶음(i, i+1, i+2) 최대한 구매
            int buyCount = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
            money += buyCount * 7;
            factory[i] -= buyCount;
            factory[i + 1] -= buyCount;
            factory[i + 2] -= buyCount;

            // 2개 묶음(i, i+1) 최대한 구매
            buyCount = Math.min(factory[i], factory[i + 1]);
            money += buyCount * 5;
            factory[i] -= buyCount;
            factory[i + 1] -= buyCount;

            // 남은 것은 1개씩 구매
            money += factory[i] * 3;
            factory[i] = 0;

            i++;
        }

        System.out.println(money);
    }
}
