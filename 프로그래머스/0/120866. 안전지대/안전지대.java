class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[][] danger = new int[board[0].length+2][board[0].length+2];
        
        for(int i = 1; i < board[0].length + 1; i++){
            for(int j = 1; j < board[0].length + 1; j++)
                if(board[i-1][j-1] == 1){
                    danger[i][j] = 1;
                    danger[i+1][j] = 1;
                    danger[i+1][j+1] = 1;
                    danger[i+1][j-1] = 1;
                    danger[i-1][j] = 1;
                    danger[i-1][j+1] = 1;
                    danger[i-1][j-1] = 1;
                    danger[i][j+1] = 1;
                    danger[i][j-1] = 1;
                }
        }
        
        for(int i = 1; i < board[0].length + 1; i++){
            for(int j = 1; j < board[0].length + 1; j++)
                if(danger[i][j] == 0) answer++;
        }
        
        return answer;
    }
}