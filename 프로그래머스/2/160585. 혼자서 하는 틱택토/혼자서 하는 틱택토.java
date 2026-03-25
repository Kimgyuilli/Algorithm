class Solution {
    public int solution(String[] board) {
        int oCount = countChar(board, 'O');
        int xCount = countChar(board, 'X');

        if (oCount < xCount || oCount - xCount > 1) return 0;

        boolean oWins = isWin(board, 'O');
        boolean xWins = isWin(board, 'X');

        if (oWins && xWins) return 0;
        if (oWins && oCount != xCount + 1) return 0;
        if (xWins && oCount != xCount) return 0;

        return 1;
    }

    private int countChar(String[] board, char target) {
        int count = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == target) count++;
            }
        }
        return count;
    }

    private boolean isWin(String[] board, char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) return true;
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) return true;
        }
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) return true;

        return false;
    }
}