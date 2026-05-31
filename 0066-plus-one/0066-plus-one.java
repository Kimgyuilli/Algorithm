class Solution {
    public int[] plusOne(int[] digits) {
        int cur = digits.length - 1;
        
        while (cur >= 0) {
            if(digits[cur] == 9) {
                digits[cur--] = 0;
            } else {
                digits[cur]++;
                return digits;
            }
        }


        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}