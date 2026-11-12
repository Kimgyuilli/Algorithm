class Solution {
    public int peakValleyDifference(int[] nums) {
        int answer = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            int left = nums[i-1];
            int n = nums[i];
            int right = nums[i+1];
            
            if(left > n && right > n) answer -= n;
            else if(left < n && right < n) answer += n;
        }
        return answer;
    }
}