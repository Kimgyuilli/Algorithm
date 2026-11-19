class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] answer = new int[2];
        int len = grid.length;
        int[] nums = new int[len * len + 1];

        for(int[] g : grid) {
            for(int n : g) {
                nums[n]++;
            }
        }

        for(int i = 1; i <= len * len; i++) {
            if(nums[i] == 2) answer[0] = i;
            else if(nums[i] == 0) answer[1] = i;
        }

        return answer;
    }
}