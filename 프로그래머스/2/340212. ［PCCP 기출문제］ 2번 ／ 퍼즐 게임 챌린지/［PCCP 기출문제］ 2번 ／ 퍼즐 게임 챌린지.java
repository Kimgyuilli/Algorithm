class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000; 
        int answer = 100000;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalTime = 0;
            
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) {
                    totalTime += times[i];
                } else {
                    long diffCount = diffs[i] - mid;
                    long prevTime = (i > 0) ? times[i - 1] : 0;
                    totalTime += (prevTime + times[i]) * diffCount + times[i];
                }
                
                if (totalTime > limit) break;
            }
            
            if (totalTime <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}