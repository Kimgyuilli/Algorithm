class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int row = 1;  
        int col = 0;  
        
        int a = 0, b = 0;
        
        for(int i = 1; i <= n*n; i++){
            answer[a][b] = i;
            
            a += col;
            b += row;
            
            if(b + row < 0 || a + col < 0 || b + row >= n || a + col >= n || answer[a + col][b + row] != 0){
                if(row == 1){        // 오른쪽 → 아래
                    row = 0;
                    col = 1;
                } else if(col == 1){ // 아래 → 왼쪽
                    row = -1;
                    col = 0;
                } else if(row == -1){ // 왼쪽 → 위
                    row = 0;
                    col = -1;
                } else{              // 위 → 오른쪽
                    row = 1;
                    col = 0;
                }
            }
        }
        
        return answer;
    }
}