class Solution {
    public int solution(int[] stones, int k) {
        int low = 1;
        int high = 200000000;
        int answer = 0;
        
        while(low <= high) {
            int mid = (high + low) / 2;
            
            if(canCross(stones, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;
        for(int stone : stones) {
            if(stone < mid) {
                skip++;
                if(skip >= k) return false;
            } else {
                skip = 0;
            }
        }
        return true;
    }
    
}