class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        int answer = 0;
        
        for(int i = 0; i < m; i++){
            map[i] = board[i].toCharArray();
        }
        
        boolean flag = true;
        while(flag) {
            flag = false;
            boolean[][] matched_map = new boolean[m][n];
            
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if(c == '0') continue;
                    if(map[i + 1][j] == c && map[i][j+1] == c && map[i + 1][j + 1] == c){
                        matched_map[i][j] = matched_map[i + 1][j] = matched_map[i][j + 1] = matched_map[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matched_map[i][j]) {
                        map[i][j] = '0';
                        answer++;   
                    }
                }
            }
            
            for(int j = 0; j < m; j++){
                int index = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '0') {
                        map[index--][j] = map[i][j];
                    }
                }
                
                while(index >= 0) {
                    map[index--][j] = '0';
                }
            }
            
            
        }
        return answer;
    }

}