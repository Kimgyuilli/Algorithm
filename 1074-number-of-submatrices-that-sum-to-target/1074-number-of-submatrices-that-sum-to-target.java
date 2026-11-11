class Solution {
    private int height, width, target;
    private int[][] prefix;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        this.height = matrix.length;
        this.width = matrix[0].length;
        this.target = target;
        this.prefix = new int[height + 1][width + 1];

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                prefix[i][j] = matrix[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int count = 0;

        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                count += findSubmat(x, y);
            }
        }

        return count;
    }

    private int findSubmat(int x, int y) {
        int count = 0;

        for (int row = 0; row <= height - y; row++) {
            for (int col = 0; col <= width - x; col++) {
                if (isMatch(row, col, x, y)) count++;
            }
        }

        return count;
    }

    private boolean isMatch(int row, int col, int x, int y) {
        int sum = prefix[row + y][col + x]
                - prefix[row][col + x]
                - prefix[row + y][col]
                + prefix[row][col];

        return sum == target;
    }
}