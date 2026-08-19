class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int answer = 0;

        for (int i = 0; i < len - 2; i++) {
            int num = nums[i];
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] - num == diff * count) count++;
                if (count >= 3) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}