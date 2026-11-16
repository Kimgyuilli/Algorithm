class Solution {
    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;

        for(int num : nums) {
            small = Math.min(small, num);
            big = Math.max(big, num);
        }

        return GCD(small, big);
    }

    private int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}