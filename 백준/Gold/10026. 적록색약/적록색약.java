import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] rootA;
    private static int[][] rootB;
    private static char[][] map;
    private static int n;
    private static final int[] DX = new int[] {1, -1, 0, 0};
    private static final int[] DY = new int[] {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        rootA = new int[n][n];
        rootB = new int[n][n];

        int Aidx = 1;
        int Bidx = 1;
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if(rootA[x][y] == 0) dfsA(x, y, Aidx++);
                if(rootB[x][y] == 0) dfsB(x, y, Bidx++);
            }
        }

        System.out.println((Aidx - 1) + " " + (Bidx - 1));
    }

    public static void dfsA(int x, int y, int idx) {
        char color = map[x][y];
        rootA[x][y] = idx;

        for(int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if(nx < 0 || nx >= n
            || ny < 0 || ny >= n
            || map[nx][ny] != color || rootA[nx][ny] > 0) continue;

            dfsA(nx, ny, idx);
        }

    }

    public static void dfsB(int x, int y, int idx) {
        char color = map[x][y];
        rootB[x][y] = idx;

        for(int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if(nx < 0 || nx >= n
                    || ny < 0 || ny >= n
            || rootB[nx][ny] > 0) continue;

            if(color == 'B' || map[nx][ny] == 'B') {
                if(color != map[nx][ny]) continue;
            }

            dfsB(nx, ny, idx);
        }
    }
}