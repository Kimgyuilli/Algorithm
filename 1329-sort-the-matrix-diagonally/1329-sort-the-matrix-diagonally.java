class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;

        for (int i = 0; i < h; i++) {
            sort(mat, i, 0);
        }

        for (int j = 1; j < w; j++) {
            sort(mat, 0, j);
        }

        return mat;
    }

    private void sort(int[][] mat, int row, int col) {
        List<Integer> nums = new ArrayList<>();

        int r = row;
        int c = col;

        while (r < mat.length && c < mat[0].length) {
            nums.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(nums);

        r = row;
        c = col;

        int idx = 0;

        while (r < mat.length && c < mat[0].length) {
            mat[r][c] = nums.get(idx++);
            r++;
            c++;
        }
    }
}