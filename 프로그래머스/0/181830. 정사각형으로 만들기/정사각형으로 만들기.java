class Solution {
    public int[][] solution(int[][] arr) {
        
        int n = arr.length;
        int m = arr[0].length;
        
        if(n == m) return arr;
        
        int max = Math.max(n, m);
        

        int[][] answer = new int[max][max];

        
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++)
                answer[i][j] = 0;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                answer[i][j] = arr[i][j];
        }
        
        return answer;
        
    }
}