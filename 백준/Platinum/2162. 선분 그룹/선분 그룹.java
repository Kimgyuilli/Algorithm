import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int n;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lines = new int[n][4];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                lines[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 선분 교차 판정 및 Union
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isIntersect(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        // 그룹 개수 및 최대 그룹 크기 계산
        Map<Integer, Integer> groupSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groupSize.put(root, groupSize.getOrDefault(root, 0) + 1);
        }

        System.out.println(groupSize.size());
        System.out.println(Collections.max(groupSize.values()));
    }

    // CCW 알고리즘
    static int ccw(int[] a, int[] b, int[] c) {
        long val = (long)(b[0] - a[0]) * (c[1] - a[1]) - (long)(b[1] - a[1]) * (c[0] - a[0]);
        return Long.compare(val, 0);
    }

    // 선분 교차 여부
    static boolean isIntersect(int[] l1, int[] l2) {
        int[] a = {l1[0], l1[1]}, b = {l1[2], l1[3]};
        int[] c = {l2[0], l2[1]}, d = {l2[2], l2[3]};

        int ab = ccw(a, b, c) * ccw(a, b, d);
        int cd = ccw(c, d, a) * ccw(c, d, b);

        if (ab == 0 && cd == 0) {
            return Math.min(a[0], b[0]) <= Math.max(c[0], d[0]) &&
                Math.max(a[0], b[0]) >= Math.min(c[0], d[0]) &&
                Math.min(a[1], b[1]) <= Math.max(c[1], d[1]) &&
                Math.max(a[1], b[1]) >= Math.min(c[1], d[1]);
        }

        return ab <= 0 && cd <= 0;
    }

    // Union-Find
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}
