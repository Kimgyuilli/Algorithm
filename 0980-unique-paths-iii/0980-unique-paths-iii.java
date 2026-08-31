class Solution {
    private final int[] dx = new int[] {0, 0, 1, -1};
    private final int[] dy = new int[] {1, -1, 0, 0};
    
    private int[][] grid;
    private int success = 0;
    private int answer = 0;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        
        int startx = 0;
        int starty = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != -1) this.success++;
                if(grid[i][j] == 1) {
                    startx = j;
                    starty = i;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        visited[starty][startx] = true;
        DFS(startx, starty, 1, visited);

        return answer;
    }

    private void DFS(int x, int y, int count, boolean[][] visited) {
        System.out.println(count);
        if(grid[y][x] == 2) {
            if(count == success) answer++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= grid[0].length || ny >= grid.length || nx < 0 || ny < 0 || grid[ny][nx] == -1) {
                continue; // 갈 수 있는지 체크
            }
            if(visited[ny][nx]) { 
                continue; // 방문했으면 스킵
            }

            visited[ny][nx] = true;
            DFS(nx, ny, count + 1, visited);
            visited[ny][nx] = false;
        }
        
        return;
    }
}