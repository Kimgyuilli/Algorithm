import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, B, C;
    static int[] factory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        factory = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        long money = 0;

        // C >= B 이면 묶으면 손해 → 그냥 전부 1개씩 구매
        if (C >= B) {
            for (int i = 0; i < N; i++) {
                money += (long) factory[i] * B;
            }
            System.out.println(money);
            return;
        }

        int i = 0;

        while (i < N) {

            // i, i+1 묶음 우선 처리
            if (factory[i + 1] > factory[i + 2]) {
                int buyCount = Math.min(factory[i], factory[i + 1] - factory[i + 2]);
                money += (long) buyCount * (B + C);
                factory[i] -= buyCount;
                factory[i + 1] -= buyCount;
            }

            // 3개 묶음 최대 구매
            int buyCount = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
            money += (long) buyCount * (B + 2 * C);
            factory[i] -= buyCount;
            factory[i + 1] -= buyCount;
            factory[i + 2] -= buyCount;

            // 2개 묶음 최대 구매
            buyCount = Math.min(factory[i], factory[i + 1]);
            money += (long) buyCount * (B + C);
            factory[i] -= buyCount;
            factory[i + 1] -= buyCount;

            // 남은 건 1개씩 구매
            money += (long) factory[i] * B;
            factory[i] = 0;

            i++;
        }

        System.out.println(money);
    }
}
