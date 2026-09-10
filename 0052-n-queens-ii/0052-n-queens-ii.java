class Solution {
    private int n;
    public int totalNQueens(int n) {
        this.n = n;

        boolean[][] map = new boolean[n][n];

        return DFS(map, 0);
    }

    private int DFS(boolean[][] map, int row) {
        if(row >= n) return 1;

        int path = 0;
        for(int i = 0; i < n; i++) {
            if(!canPlace(map, row, i)) continue;
                map[row][i] = true;
                path += DFS(map, row + 1);
                map[row][i] = false;
        }

        return path;
    }

    private boolean canPlace(boolean[][] map, int row, int col) {
        for(int i = row - 1; i >= 0; i--) {
            if(map[i][col] == true) return false;
        }
        for(int i = 1; i <= row; i++) {
            if(col - i < 0) break;
            if(map[row - i][col - i]) return false;
        }

        for(int i = 1; i <= row; i++) {
            if(col + i >= n) break;
            if(map[row - i][col + i]) return false;
        }

        return true;
    }
}