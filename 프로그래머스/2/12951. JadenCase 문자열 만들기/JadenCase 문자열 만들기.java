class Solution {
    public String solution(String s) {
        
        boolean isFirst = true;
        s = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(c);
                isFirst = true;
                continue;
            } 
            
            if(isFirst && c >= 'a' && c <= 'z') {
                sb.append((char) (c - 32));
            } else {
                sb.append(c);
            }
            isFirst = false;
        }
        
        
        return sb.toString();
    }
}