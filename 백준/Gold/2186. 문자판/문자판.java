import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] board;
    static String word;
    static int[][][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        K = Integer.parseInt(st.nextToken()); // 단어 길이

        board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        word = br.readLine();
        dp = new int[N][M][word.length()];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                Arrays.fill(dp[i][j], -1);


        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == word.charAt(0)) {
                    answer += dfs(i, j, 0); // 시작 위치에서 첫 글자 매칭
                }
            }
        }

        System.out.println(answer);
    }
    static int dfs(int x, int y, int index) {
        if(index == word.length() - 1) {
            return 1; // 단어의 마지막 글자까지 도달
        }
        if(dp[x][y][index] != -1) {
            return dp[x][y][index]; // 이미 계산된 경우
        }

        dp[x][y][index] = 0; // 초기화

        for (int d = 0; d < 4; d++) {
            for (int step = 1; step <= K; step++) {
                int nx = x + dx[d] * step;
                int ny = y + dy[d] * step;

                if (0 <= nx && nx < N && 0 <= ny && ny < M &&
                        board[nx][ny] == word.charAt(index + 1)) {
                    dp[x][y][index] += dfs(nx, ny, index + 1);
                }
            }
        }

        return dp[x][y][index];
    }
}
