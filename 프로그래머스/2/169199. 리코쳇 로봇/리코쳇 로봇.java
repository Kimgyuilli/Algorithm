import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    public int solution(String[] board) {
        
        int height = board.length;
        int width = board[0].length();
        
        int startX = 0, startY = 0;
        
        char[][] map = new char[height][width];
        visited = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            map[i] = board[i].toCharArray();
            if(board[i].contains("R")){
                startY = i;
                startX = board[i].indexOf("R");
            }
        }
        
        visited[startY][startX] = true;
        int answer = bfs(map, startX, startY);
        
        return answer;
    }
    
    private int bfs(char[][] map, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int depth = cur[2];
            
            if(map[cy][cx] == 'G') return depth;
            
            for(int i = 0; i < 4; i++) {
                int[] next = getNext(map, cx, cy, i);
                int nx = next[0];
                int ny = next[1];
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[] {nx, ny, depth + 1});
                }
            }
        }
        return -1;
    }
    
    private int[] getNext(char[][] map, int x, int y, int i) {
        while(y+dy[i] >= 0 && x+dx[i] >= 0
             && y+dy[i] < map.length && x+dx[i] < map[0].length
             && map[y+dy[i]][x+dx[i]] != 'D') {
            x += dx[i];
            y += dy[i];
        }
        return new int[] {x, y};
    }
}