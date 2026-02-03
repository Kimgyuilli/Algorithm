class Solution {
    public int solution(int[][] dots) {
        
        int width = 0;
        int height = 0;
        
        for(int i = 1; i < 4; i++){
            if(dots[i][0] == dots[0][0]) height = Math.abs(dots[i][1] - dots[0][1]);
            else if(dots[i][1] == dots[0][1]) width = Math.abs(dots[i][0] - dots[0][0]);
        }
        
        
        return width * height;
    }
}