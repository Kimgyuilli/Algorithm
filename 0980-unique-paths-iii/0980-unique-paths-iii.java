class Solution {
    private final int[] DX = new int[] {0, 0, 1, -1};
    private final int[] DY = new int[] {1, -1, 0, 0};
    
    private int[][] grid;
    private int row;
    private int col;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;

        int startX = 0;
        int startY = 0;
        int workableCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != -1) workableCount++;
                if(grid[i][j] == 1) {
                    startX = j;
                    startY = i;
                }
            }
        }

        this.grid[startY][startX] = -1;
        return DFS(startX, startY, workableCount - 1);
    }

    private int DFS(int x, int y, int workableCount) {
        if(grid[y][x] == 2) {
            return 1;
        }
        
        grid[y][x] = -1;
        int path = 0;

        for(int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if(nx >= col || ny >= row || nx < 0 || ny < 0 || grid[ny][nx] == -1) {
                continue; // 갈 수 있는지 체크
            }
            if (grid[ny][nx] == 2 && workableCount - 1 > 0) {
                continue; // 너무 일찍 목표 도착
            }

            path += DFS(nx, ny, workableCount - 1);
        }
        
        grid[y][x] = 0;
        return path;
    }
}