class Solution {
    int[] board;
    int answer;
    public int solution(int n) {
        board = new int[n];
        answer = 0;
        backTrack(0, n);
        return answer;
    }
    
    private void backTrack(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int col = 0; col < n; col++) {
            board[row] = col;
            
            if(isValid(row)){
                backTrack(row + 1, n);
            }
        }
    }
    
    private boolean isValid(int row) {
        for(int i = 0; i < row; i++) {
            if(board[i] == board[row]) return false;
            if((row - i) == Math.abs(board[row] - board[i])) return false;
        }
        return true;
    }
}