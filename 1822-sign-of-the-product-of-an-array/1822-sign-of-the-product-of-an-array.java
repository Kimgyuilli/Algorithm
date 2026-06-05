class Solution {
    public int arraySign(int[] nums) {
        long prod = 1;

        for(int i : nums) {
            if(i == 0) return 0;
            if(i < 0) prod *= -1;
        }

        if(prod < 0) return -1;
        return 1;
    }
}