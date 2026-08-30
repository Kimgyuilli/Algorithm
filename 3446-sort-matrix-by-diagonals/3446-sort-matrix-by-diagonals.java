class Solution {
    public int[][] sortMatrix(int[][] grid) {
        
        int n = grid.length;

        for(int startRow = 0; startRow < n; startRow++) {
            int length = n - startRow;
            int[] list = new int[length];

            for(int i = 0; i < length; i++) {
                list[i] = grid[startRow + i][i];
            }

            Arrays.sort(list);

            for(int i = 0; i < length; i++) {
                grid[startRow + i][i] = list[length - 1 - i];
            }
        }

        for(int startCol = 1; startCol < n; startCol++) {
            int length = n - startCol;
            int[] list = new int[length];

            for(int i = 0; i < length; i++) {
                list[i] = grid[i][startCol + i];
            }

            Arrays.sort(list);

            for(int i = 0; i < length; i++) {
                grid[i][startCol + i] = list[i];
            }
        }


        return grid;
    }
}