class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) { 
                    triangle[i][j] += triangle[i-1][j];
                    continue;
                } 
                if(j == i) { 
                    triangle[i][j] += triangle[i-1][j - 1];
                    continue;
                } 
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j - 1]);
            }
        }
        
        int answer = -1;
        
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, triangle[n-1][i]);
        }
        return answer;
    }
}