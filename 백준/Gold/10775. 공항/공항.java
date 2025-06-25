import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int G, P;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];

        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());

            int dockingGate = find(gi);
            if (dockingGate == 0) break; // 도킹할 수 있는 게이트 없음

            union(dockingGate, dockingGate - 1); // 도킹 후, 다음 가능한 게이트로 연결
            result++;
        }

        System.out.println(result);

    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }


}
