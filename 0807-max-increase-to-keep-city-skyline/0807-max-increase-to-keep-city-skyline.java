class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] rowMax = new int[row];
        int[] colMax = new int[col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] > rowMax[i]) {
                    rowMax[i] = grid[i][j];
                }
                if(grid[i][j] > colMax[j]) {
                    colMax[j] = grid[i][j];
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                answer += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return answer;
    }
}