class Solution {
    public int solution(int[] players, int m, int k) {
        
        int increaseCount = 0;
        int[] increaseMap = new int[24];
        int current = 0;
        
        for(int i = 0; i < 24; i++){
            
            if(i >= k){
                current -= increaseMap[i - k];
            }
            
            int need = players[i] / m;
            
            if(current < need) {
                int needed = need - current;
                
                current += needed;
                increaseMap[i] = needed;
                increaseCount += needed;
            }
        }
        
        return increaseCount;
    }
}