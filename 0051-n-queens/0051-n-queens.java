class Solution {
    private int n;
    private List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.answer = new ArrayList<>();

        boolean[][] board = new boolean[n][n];
        dfs(board, 0);

        return answer;
    }

    private void dfs(boolean[][] board, int depth) {
        if(depth == n) {
            record(board);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!canPlace(board, depth, i)) continue;

            board[depth][i] = true;
            dfs(board, depth + 1);
            board[depth][i] = false;
        }
    }

    private void record(boolean[][] board) {
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            sb.setLength(0); 
            boolean[] row = board[i];
            for(boolean b : row){
                if(b) sb.append('Q');
                else sb.append('.');
            }
            temp.add(sb.toString());
        }
        answer.add(temp);
        
    }

    private boolean canPlace(boolean[][] board, int row, int col) {
        
        int count = 1;
        for(int curRow = row - 1; curRow >= 0; curRow--) {
            // 상단
            if(board[curRow][col]) return false;
            // 좌상단
            if(col - count >= 0 && board[curRow][col - count]) return false;
            // 우상단
            if(col + count < n && board[curRow][col + count]) return false;
            count++;
        }
        return true;

    }
}