import java.util.*;

class Solution {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    boolean[][] visited;
    int[] cols;
    int height, width;
    
    public int solution(int[][] land) {
        
        height = land.length;
        width = land[0].length;
        
        visited = new boolean[height][width];
        cols = new int[width];
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(!visited[i][j] && land[i][j] == 1) BFS(j, i, land);
            }
        }

        int answer = 0;
        for(int i : cols) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
    
    private void BFS(int x, int y, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[y][x] = true;

        int count = 0;
        Set<Integer> columnSet = new HashSet<>();
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            columnSet.add(cur[0]);
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= width
                  || ny < 0 || ny >= height
                  || visited[ny][nx] || land[ny][nx] == 0) {
                    continue;
                }
                
                q.offer(new int[] {nx, ny});
                visited[ny][nx] = true;
            }
        }
        for (int colIndex : columnSet) {
            cols[colIndex] += count;
        }
    }
}