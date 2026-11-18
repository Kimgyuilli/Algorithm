class Solution {
    public String stringHash(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int idx = 0;
        for(char c : s.toCharArray()) {
            idx++;
            
            sum += c - 'a';

            if(idx == k) {
                char ch = (char) ('a' + (sum % 26));
                sb.append(ch);
                sum = 0;
                idx = 0;
            }
        }

        return sb.toString();
    }
}