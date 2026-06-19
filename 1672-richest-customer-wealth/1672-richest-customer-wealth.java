class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for(int[] account : accounts) {
            int sum = 0;
            for(int n : account) {
                sum += n;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}