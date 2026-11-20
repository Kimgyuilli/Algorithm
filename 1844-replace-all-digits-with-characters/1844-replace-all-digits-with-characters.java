class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                sb.append((char)(s.charAt(i - 1) + (c - '0')));
            }
        }

        return sb.toString();
    }
}