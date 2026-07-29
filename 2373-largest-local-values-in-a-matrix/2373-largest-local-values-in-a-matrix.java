class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] answer = new int[n - 2][n - 2];

        for (int row = 0; row < n - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                int max = 0;

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        max = Math.max(max, grid[i][j]);
                    }
                }

                answer[row][col] = max;
            }
        }

        return answer;
    }
}