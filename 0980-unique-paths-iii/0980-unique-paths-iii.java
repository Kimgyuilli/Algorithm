class Solution {
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    private int[][] grid;
    private int rows;
    private int cols;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        int startX = 0;
        int startY = 0;
        int walkableCount = 0;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (grid[y][x] != -1) {
                    walkableCount++;
                }

                if (grid[y][x] == 1) {
                    startX = x;
                    startY = y;
                }
            }
        }

        return dfs(startX, startY, walkableCount);
    }

    private int dfs(int x, int y, int remaining) {
        if (grid[y][x] == 2) {
            return remaining == 1 ? 1 : 0;
        }

        int original = grid[y][x];
        grid[y][x] = -1;

        int paths = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= cols || ny < 0 || ny >= rows) {
                continue;
            }

            if (grid[ny][nx] == -1) {
                continue;
            }

            paths += dfs(nx, ny, remaining - 1);
        }

        grid[y][x] = original; // 백트래킹
        return paths;
    }
}