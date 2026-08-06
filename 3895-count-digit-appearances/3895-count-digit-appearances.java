class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int answer = 0;

        for(int num : nums) {
            while(num > 0) {
                if(num % 10 == digit) answer++;
                num /= 10;
            }
        }

        return answer;
    }
}