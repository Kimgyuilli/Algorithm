import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] lake;
    static boolean[][] visited;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> swanQ = new LinkedList<>();
    static Queue<int[]> swanNextQ = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] swan1, swan2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new char[R][C];
        visited = new boolean[R][C];

        int swanCount = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] != 'X') {
                    waterQ.add(new int[]{i, j});
                }
                if (lake[i][j] == 'L') {
                    if (swanCount == 0) {
                        swan1 = new int[]{i, j};
                        swanQ.add(swan1);
                        visited[i][j] = true;
                        swanCount++;
                    } else {
                        swan2 = new int[]{i, j};
                    }
                }
            }
        }

        int day = 0;
        while (true) {
            if (moveSwan()) {
                System.out.println(day);
                break;
            }
            melt();
            swanQ = swanNextQ;
            swanNextQ = new LinkedList<>();
            day++;
        }
    }

    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            int[] cur = swanQ.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
                visited[nx][ny] = true;

                if (lake[nx][ny] == '.') {
                    swanQ.add(new int[]{nx, ny});
                } else if (lake[nx][ny] == 'X') {
                    swanNextQ.add(new int[]{nx, ny});
                } else if (lake[nx][ny] == 'L') {
                    return true;
                }
            }
        }
        return false;
    }

    static void melt() {
        int size = waterQ.size();
        while (size-- > 0) {
            int[] cur = waterQ.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                if (lake[nx][ny] == 'X') {
                    lake[nx][ny] = '.';
                    waterQ.add(new int[]{nx, ny});
                }
            }
        }
    }
}
