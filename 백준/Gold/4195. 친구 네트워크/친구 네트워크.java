import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int T, F;
    static int[] parent, size;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());

            parent = new int[2 * F];  // 최대 F쌍 → 최대 인원 2 * F
            size = new int[2 * F];
            map = new HashMap<>();

            int idx = 0;

            for(int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                // a가 처음 나오면 map에 등록
                if (!map.containsKey(a)) {
                    map.put(a, idx);
                    parent[idx] = idx;  // 자기 자신을 부모로 초기화
                    size[idx] = 1;      // size = 1
                    idx++;
                }

                // b가 처음 나오면 map에 등록
                if (!map.containsKey(b)) {
                    map.put(b, idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }

                int rootA = find(map.get(a));
                int rootB = find(map.get(b));

                if (rootA != rootB){
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }

                System.out.println(size[find(rootA)]);

            }
        }
    }
    static int find(int x){
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
