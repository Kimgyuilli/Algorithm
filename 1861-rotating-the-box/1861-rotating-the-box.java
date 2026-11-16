class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (char[] row : boxGrid) {
            int write = n - 1;

            for (int i = n - 1; i >= 0; i--) {
                if (row[i] == '*') {
                    write = i - 1;
                } else if (row[i] == '#') {
                    row[i] = '.';
                    row[write] = '#';
                    write--;
                }
            }
        }

        char[][] answer = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return answer;
    }
}