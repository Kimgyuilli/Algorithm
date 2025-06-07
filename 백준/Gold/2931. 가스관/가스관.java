import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    // 상, 하, 좌, 우 순서로 true/false
    static boolean[][] pipeDir = new boolean[128][];  // ASCII 기준

    static {
        pipeDir['|'] = new boolean[]{true, true, false, false};
        pipeDir['-'] = new boolean[]{false, false, true, true};
        pipeDir['+'] = new boolean[]{true, true, true, true};
        pipeDir['1'] = new boolean[]{false, true, false, true};  // ↘
        pipeDir['2'] = new boolean[]{true, false, false, true};  // ↗
        pipeDir['3'] = new boolean[]{true, false, true, false};  // ↖
        pipeDir['4'] = new boolean[]{false, true, true, false};  // ↙
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int missingX = -1, missingY = -1;

        // 끊긴 지점 찾기
        outer:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    for (int dir = 0; dir < 4; dir++) {
                        int ni = i + dx[dir];
                        int nj = j + dy[dir];
                        if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                        char neighbor = map[ni][nj];
                        if (pipeDir[neighbor] != null && pipeDir[neighbor][dir ^ 1]) {
                            missingX = i;
                            missingY = j;
                            break outer;
                        }
                    }
                }
            }
        }

        // 필요한 방향 찾기
        boolean[] needed = new boolean[4]; // 상하좌우 방향
        for (int dir = 0; dir < 4; dir++) {
            int nx = missingX + dx[dir];
            int ny = missingY + dy[dir];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            char adj = map[nx][ny];
            if (pipeDir[adj] != null && pipeDir[adj][(dir ^ 1)]) {
                needed[dir] = true;
            }
        }

        // 어떤 파이프인지 판단
        char pipeType = '?';
        for (char type : new char[]{'|', '-', '+', '1', '2', '3', '4'}) {
            boolean[] dirs = pipeDir[type];
            boolean match = true;
            for (int i = 0; i < 4; i++) {
                if (needed[i] != dirs[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                pipeType = type;
                break;
            }
        }

        System.out.println((missingX + 1) + " " + (missingY + 1) + " " + pipeType);
    }
}
