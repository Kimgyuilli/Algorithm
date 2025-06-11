import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, zeroLabel;
    static int N, M;
    static boolean zeroVisited[][];


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        zeroVisited = new boolean[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        zeroLabel = new int[N][M];
        Map<Integer, Integer> labelSizeMap = new HashMap<>();
        int label = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !zeroVisited[i][j]) {
                    int areaSize = dfs(i, j, label);
                    labelSizeMap.put(label, areaSize);
                    label++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sb.append(0);
                } else {
                    int sum = 1; // 현재 벽 칸 포함
                    boolean[] visitedLabels = new boolean[label];

                    for (int dir = 0; dir < 4; dir++) {
                        int ni = i + dx[dir];
                        int nj = j + dy[dir];

                        if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            int adjLabel = zeroLabel[ni][nj];
                            if (map[ni][nj] == 0 && !visitedLabels[adjLabel]) {
                                visitedLabels[adjLabel] = true;
                                sum += labelSizeMap.get(adjLabel);
                            }
                        }
                    }
                    sb.append(sum % 10);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());


    }

    static int dfs(int x, int y, int label) {
        if(x < 0 || x >= N || y < 0 || y >= M || zeroVisited[x][y] || map[x][y] != 0)
            return 0;

        zeroVisited[x][y] = true;
        zeroLabel[x][y] = label;

        int count = 1;
        count += dfs(x + 1, y, label);
        count += dfs(x - 1, y, label);
        count += dfs(x, y + 1, label);
        count += dfs(x, y - 1, label);

        return count;
    }
}