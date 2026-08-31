class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rowSum = new int[n];
        int[] colSum = new int[m];
        int[][] diff = new int[n][m];

        int add = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                add = 1;
                if(grid[i][j] == 0) add = -1;
                
                rowSum[i] += add;
                colSum[j] += add;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                diff[i][j] += rowSum[i] + colSum[j];
            }
        }

        return diff;
    }
}