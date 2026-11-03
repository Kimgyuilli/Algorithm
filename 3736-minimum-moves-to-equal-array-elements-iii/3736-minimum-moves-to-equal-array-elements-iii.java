class Solution {
    public int minMoves(int[] nums) {
        int max = 0;

        for(int num : nums) {
            max = Math.max(max, num);
        }

        int answer = 0;
        for(int num : nums) {
            answer += max - num;
        }
        return answer;
    }
}