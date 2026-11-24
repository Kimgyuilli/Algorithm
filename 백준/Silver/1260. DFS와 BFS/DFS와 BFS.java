import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder
    static boolean[] check; // 방문 여부 체크 배열
    static int[][] arr; // 인접 행렬로 그래프를 저장

    static int node, line, start; // 노드 개수, 간선 개수, 시작 노드

    static Queue<Integer> q = new LinkedList<>(); // BFS 탐색을 위한 큐

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 노드 개수, 간선 개수, 시작 노드
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1]; // 1-based index 사용
        check = new boolean[node + 1]; // 방문 배열 초기화

        // 간선 정보 입력 및 인접 행렬 생성
        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1; // 무방향 그래프이므로 양쪽에 값 저장
        }

        // DFS 탐색 수행
        dfs(start);
        sb.append("\n"); // 줄바꿈

        // BFS 탐색을 위해 방문 배열 초기화
        check = new boolean[node + 1];

        // BFS 탐색 수행
        bfs(start);

        // 결과 출력
        System.out.println(sb);
    }

    // 깊이 우선 탐색 (DFS) 구현
    public static void dfs(int start) {
        check[start] = true; // 현재 노드 방문 처리
        sb.append(start + " "); // 방문한 노드 결과 저장

        // 인접 노드 탐색
        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) // 연결되어 있고, 방문하지 않았다면
                dfs(i); // 재귀 호출
        }
    }

    // 너비 우선 탐색 (BFS) 구현
    public static void bfs(int start) {
        q.add(start); // 시작 노드를 큐에 삽입
        check[start] = true; // 방문 처리

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            start = q.poll(); // 큐에서 노드 꺼내기
            sb.append(start + " "); // 방문한 노드 결과 저장

            // 인접 노드 탐색
            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) { // 연결되어 있고, 방문하지 않았다면
                    q.add(i); // 큐에 삽입
                    check[i] = true; // 방문 처리
                }
            }
        }
    }
}
