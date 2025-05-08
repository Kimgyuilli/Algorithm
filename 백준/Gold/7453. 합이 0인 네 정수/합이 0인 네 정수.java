import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] abSum, cdSum;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];
        abSum = new int[N * N];
        cdSum = new int[N * N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                abSum[idx] = arr[0][i] + arr[1][j];
                cdSum[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(cdSum);

        long total = 0;
        for (int ab : abSum) {
            int target = -ab;
            int lower = lowerBound(cdSum, target);
            int upper = upperBound(cdSum, target);
            total += (upper - lower);
        }

        System.out.println(total);
    }

    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
