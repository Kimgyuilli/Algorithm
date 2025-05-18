import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            parent = new int[m + 1];

            for (int j = 0; j < m - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(find(a, b));
        }
    }

    static int find(int a, int b) {
        Set<Integer> ancestors = new HashSet<>();
        while (a != 0) {
            ancestors.add(a);
            a = parent[a];
        }

        while (b != 0) {
            if (ancestors.contains(b)) {
                return b;
            }
            b = parent[b];
        }

        return 0;
    }
}
