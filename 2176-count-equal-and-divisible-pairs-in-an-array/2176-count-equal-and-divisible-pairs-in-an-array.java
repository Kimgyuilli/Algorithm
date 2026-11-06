class Solution {
    public int countPairs(int[] nums, int k) {
        int len = nums.length;
        int answer = 0;

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if((i * j) % k != 0 || nums[i] != nums[j]) continue;

                answer++;
            }
        }

        return answer;
    }
}