class Solution {
    public int totalWaviness(int num1, int num2) {
        if (num2 < 100) return 0;

        int result = 0;

        for (int i = num1; i <= num2; i++) {
            if (i < 100) continue;

            String num = i + "";

            for (int j = 1; j < num.length() - 1; j++) {
                char prev = num.charAt(j - 1);
                char cur = num.charAt(j);
                char next = num.charAt(j + 1);

                if ((cur > prev && cur > next) ||
                    (cur < prev && cur < next)) {
                    result++;
                }
            }
        }

        return result;
    }
}