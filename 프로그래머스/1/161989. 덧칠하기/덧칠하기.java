class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] painted = new boolean[n + 1];
        
        
        for(int i : section){
            if(painted[i]) continue;
            
            for(int j = i; j < Math.min(i + m, n + 1); j++){
                painted[j] = true;
            }
            answer++;
        }
        
        return answer;
    }
}