class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50,
            'C', 100, 'D', 500, 'M', 1000
        );

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = values.get(s.charAt(i));
            // 다음 글자가 더 크면 이 글자는 빼야 함 (IV, IX, XL 등)
            if (i + 1 < s.length() && current < values.get(s.charAt(i + 1))) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        return sum;
    }
}