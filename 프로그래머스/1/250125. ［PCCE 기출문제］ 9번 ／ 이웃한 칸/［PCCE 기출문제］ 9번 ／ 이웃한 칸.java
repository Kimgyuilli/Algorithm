class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++){
            
            if(h+dx[i] >= board.length || w+dy[i] >= board.length || h+dx[i] < 0 || w+dy[i] < 0)
                continue;
            
            String compareColor = board[h+dx[i]][w+dy[i]];
            
            if(compareColor.equals(color)) answer++;
        }
        
        return answer;
    }
}