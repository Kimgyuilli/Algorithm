import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, tree;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }


        tree = new long[4 * N];
        build(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 1) {
                update(1, 1, N, a, b);
            } else if (command == 2) {
                System.out.println(query(1, 1, N, a, b));
            }
        }
    }

    // 트리 빌드
    static long build(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start] % MOD;
        int mid = (start + end) / 2;
        return tree[node] = (build(node * 2, start, mid) * build(node * 2 + 1, mid + 1, end)) % MOD;
    }

    // 값 업데이트
    static long update(int node, int start, int end, int idx, long val) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) return tree[node] = val % MOD;
        int mid = (start + end) / 2;
        return tree[node] = (update(node * 2, start, mid, idx, val) * update(node * 2 + 1, mid + 1, end, idx, val)) % MOD;
    }

    // 구간 곱 쿼리
    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 1; // 곱의 항등원
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
    }
}
