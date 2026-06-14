class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String s : words) {
            char[] ch = s.toCharArray();
            int sum = 0;

            for(char c : ch) {
                sum += weights[c - 'a'];
            }
            sb.append((char)('z' - (sum % 26)));
        }
        return sb.toString();
    }
}