import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map = new char[8][8]; // 맵
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1, 0}; // 상하좌우 & 대각선 & 제자리 9방향
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1, 0};


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<State> q = new LinkedList<>();
        boolean[][][] visited = new boolean[8][8][9]; // 방문 여부 (x, y, 시간)

        q.add(new State(7, 0, 0));
        visited[7][0][0] = true;

        while(!q.isEmpty()){
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int time = cur.time;
            if(x == 0 && y == 7) {
                return 1;
            }
            if(isWall(x, y, time)) continue;
            for (int i = 0; i < 9; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nt = Math.min(time + 1, 8);
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8
                        && !visited[nx][ny][nt]
                        && !isWall(nx, ny, time)
                        && !isWall(nx, ny, nt)) {
                    visited[nx][ny][nt] = true;
                    q.add(new State(nx, ny, nt));
                }
            }
        }
        return 0;
    }
    static boolean isWall(int x, int y, int time) {
        int wallX = x - time;
        return wallX >= 0 && map[wallX][y] == '#';
    }


    static class State{
        int x, y, time;

        State(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}