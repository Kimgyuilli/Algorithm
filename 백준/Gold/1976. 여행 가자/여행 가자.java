import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static int[][] map;
    static int NumOfCity, NumOfPlan;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        NumOfCity = Integer.parseInt(br.readLine());
        NumOfPlan = Integer.parseInt(br.readLine());

        set = new int[NumOfCity + 1];
        map = new int[NumOfCity + 1][NumOfCity + 1];

        for (int i = 1; i <= NumOfCity; i++) {
            set[i] = i; // 각 도시의 부모를 자기 자신으로 설정
        }

        // 인접 행렬 입력 받기
        for(int i = 1; i <= NumOfCity; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= NumOfCity; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        // Union-Find 알고리즘을 사용하여 연결된 도시를 찾기
        for (int i = 1; i <= NumOfCity; i++) {
            for (int j = 1; j <= NumOfCity; j++) {
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력 받기
        String[] plan = br.readLine().split(" ");
        int firstCity = find(Integer.parseInt(plan[0]));
        boolean possible = true;
        for (int i = 1; i < NumOfPlan; i++) {
            if (find(Integer.parseInt(plan[i])) != firstCity) {
                possible = false;
                break;
            }
        }
        System.out.println(possible ? "YES" : "NO");

    }
    // Find 함수 - 루트 찾기
    static int find(int x) {
        if (set[x] != x) {
            set[x] = find(set[x]); // 경로 압축
        }
        return set[x];
    }

    // Union 함수 - 두 집합을 합침
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            set[b] = a;
        }
    }
}
