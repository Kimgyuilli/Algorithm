class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                int preMax = 0;
                for(int k = 0; k < 4; k++){
                    if(j != k) preMax = Math.max(preMax, land[i-1][k]);
                }
                land[i][j] += preMax;
            }
        }
        
        for(int i = 0; i < land[0].length; i++) {
            int findlen = land.length - 1;
            answer = Math.max(answer, land[findlen][i]);
        }

        return answer;
    }
}