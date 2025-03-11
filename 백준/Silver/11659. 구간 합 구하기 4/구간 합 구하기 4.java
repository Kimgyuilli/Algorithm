import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        prefixSum = new int[N + 1]; // 누적합 배열 (1-based index 사용)

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
            arr[k] = Integer.parseInt(st.nextToken());
            prefixSum[k + 1] = prefixSum[k] + arr[k]; // 누적합 저장
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1; // 1-based index 조정
            int j = Integer.parseInt(st.nextToken()); // j는 그대로 (prefixSum은 1-based)

            int sum = prefixSum[j] - prefixSum[i]; // O(1) 시간 복잡도
            sb.append(sum).append("\n");
        }
        System.out.print(sb); // 출력 최적화
    }
}
