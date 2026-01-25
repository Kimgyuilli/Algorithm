class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s.length());
        boolean isWordStart = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                isWordStart = true;
            } else {
                answer.append(isWordStart ? Character.toUpperCase(c) : Character.toLowerCase(c));
                isWordStart = false;
            }
        }
        
        return answer.toString();
    }
}