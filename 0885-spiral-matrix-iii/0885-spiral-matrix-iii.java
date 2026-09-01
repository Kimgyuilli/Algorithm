class Solution {
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    public int[][] spiralMatrixIII(
            int rows,
            int cols,
            int rStart,
            int cStart
    ) {
        int[][] result = new int[rows * cols][2];

        int count = 0;
        int row = rStart;
        int col = cStart;
        int direction = 0;
        int moveLength = 1;

        result[count++] = new int[] {row, col};

        while (count < rows * cols) {
            // 같은 길이로 두 방향씩 이동
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int step = 0; step < moveLength; step++) {
                    row += DR[direction];
                    col += DC[direction];

                    if (row >= 0 && row < rows &&
                        col >= 0 && col < cols) {
                        result[count++] = new int[] {row, col};

                        if (count == rows * cols) {
                            return result;
                        }
                    }
                }

                direction = (direction + 1) % 4;
            }

            moveLength++;
        }

        return result;
    }
}