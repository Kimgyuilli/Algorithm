import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int [][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] check = new boolean[N][M][K+1];
        q.add(new int[] {0,0,K,1});

        int cnt = -1;
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0], py = p[1];
            int chance = p[2], move = p[3];

            if(px==M-1 && py == N-1) {
                return cnt = move;
            }
            for(int i=0; i<4; i++) {
                int nx = px+dx[i];
                int ny = py+dy[i];

                if(nx<0|| ny<0 || nx>M-1 || ny>N-1 || check[ny][nx][chance]) continue;

                if(map[ny][nx] == 0) {
                    check[ny][nx][chance] = true;
                    q.add(new int[] {nx, ny, chance, move+1});
                }else {
                    if(chance >0) {
                        check[ny][nx][chance] = true;
                        q.add(new int[] {nx, ny, chance-1, move+1});
                    }
                }
            }
        }
        return cnt;
    }
}