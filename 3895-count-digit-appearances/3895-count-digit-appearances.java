class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        StringBuilder sb = new StringBuilder();

        for(int num : nums) {
            sb.append(num);
        }

        String regular = "[^" + digit + "]";

        return sb.toString().replaceAll(regular, "").length();
    }
}