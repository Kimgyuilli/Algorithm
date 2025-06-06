import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int minVal = 200, maxVal = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minVal = Math.min(minVal, map[i][j]);
                maxVal = Math.max(maxVal, map[i][j]);
            }
        }

        int left = 0, right = maxVal - minVal, result = right;

        while(left <= right) {
            int mid = (left + right) / 2;
            boolean pathExists = false;

            for(int low = minVal; low + mid <= maxVal; low++) {
                int high = low + mid;
                visited = new boolean[N][N];

                if (map[0][0] >= low && map[0][0] <= high && bfs(low, high)) {
                    pathExists = true;
                    break;
                }
            }

            if (pathExists) {
                result = mid;
                right = mid -1;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(result);

    }

    static boolean bfs(int low, int high) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int now[] = q.poll();
            int x = now[0], y = now[1];
            if (x == N - 1 && y == N - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x +dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] >= low && map[nx][ny] <= high ){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;

    }
}
