import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();

        for (int x : A) {
            int idx = Collections.binarySearch(lis, x);
            if (idx < 0) idx = -idx - 1;

            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        System.out.println(lis.size());
    }
}
