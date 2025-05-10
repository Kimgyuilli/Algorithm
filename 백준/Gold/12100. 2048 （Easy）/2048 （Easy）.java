import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int max = 0;

    static final int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, map);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            updateMax(board);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] moved = move(board, dir);
            dfs(depth + 1, moved);
        }
    }

    static int[][] move(int[][] board, int dir) {
        int[][] newBoard = deepCopy(board);
        boolean[][] merged = new boolean[n][n];

        // 방향에 따라 순회 순서 결정
        int start = 0, end = n, step = 1;
        if (dir == 1 || dir == 2) { // 우, 하
            start = n - 1; end = -1; step = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = start; j != end; j += step) {
                int x = (dir == 0 || dir == 2) ? j : i;
                int y = (dir == 0 || dir == 2) ? i : j;

                if (newBoard[x][y] == 0) continue;

                int nx = x;
                int ny = y;

                while (true) {
                    int tx = nx + dx[dir];
                    int ty = ny + dy[dir];

                    if (tx < 0 || ty < 0 || tx >= n || ty >= n) break;
                    if (newBoard[tx][ty] == 0) {
                        newBoard[tx][ty] = newBoard[nx][ny];
                        newBoard[nx][ny] = 0;
                        nx = tx;
                        ny = ty;
                    } else if (newBoard[tx][ty] == newBoard[nx][ny] && !merged[tx][ty]) {
                        newBoard[tx][ty] *= 2;
                        newBoard[nx][ny] = 0;
                        merged[tx][ty] = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        return newBoard;
    }

    static void updateMax(int[][] board) {
        for (int[] row : board)
            for (int val : row)
                max = Math.max(max, val);
    }

    static int[][] deepCopy(int[][] src) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++)
            copy[i] = src[i].clone();
        return copy;
    }
}
