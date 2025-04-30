import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map = new char[10][10];
    static int[] dx = {0, 1, 1, -1};  // 가로, 세로, 대각 ↘, 대각 ↙
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'X';  // 놓아보기

                    if (isWinning()) {
                        System.out.println(1);
                        return;
                    }

                    map[i][j] = '.';  // 복원
                }
            }
        }

        System.out.println(0);  // 한 칸 바꿔도 불가능
    }

    static boolean isWinning() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 'X') {
                    for (int dir = 0; dir < 4; dir++) {
                        int count = 1;

                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        while (isIn(nx, ny) && map[nx][ny] == 'X') {
                            count++;
                            nx += dx[dir];
                            ny += dy[dir];
                        }

                        if (count >= 5) return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < 10 && 0 <= y && y < 10;
    }
}
