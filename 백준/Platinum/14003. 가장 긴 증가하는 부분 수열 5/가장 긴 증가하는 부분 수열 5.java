import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, idxArr, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        idxArr = new int[N];   
        prev = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        ArrayList<Integer> lisIndices = new ArrayList<>();

        int[] ends = new int[N];

        int len = 0;
        for (int i = 0; i < N; i++) {
            int pos = Collections.binarySearch(lis, A[i]);
            if (pos < 0) pos = -pos - 1;

            if (pos == lis.size()) {
                lis.add(A[i]);
            } else {
                lis.set(pos, A[i]);
            }

            idxArr[i] = pos;
            ends[pos] = i;
            if (pos > 0) {
                prev[i] = ends[pos - 1];
            } else {
                prev[i] = -1;
            }

            len = Math.max(len, pos + 1);
        }

        // 결과 복원
        Deque<Integer> result = new ArrayDeque<>();
        int cur = ends[len - 1];
        while (cur != -1) {
            result.addFirst(A[cur]);
            cur = prev[cur];
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        for (int val : result) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}
