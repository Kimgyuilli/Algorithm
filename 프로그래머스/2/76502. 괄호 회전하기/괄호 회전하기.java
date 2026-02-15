import java.util.*;

class Solution {
    public int solution(String s) {
        
        int len = s.length();
        int answer = 0;
        char[] array = s.toCharArray();
        
        for(int i = 0; i < len; i++) {
            Deque<Character> dq = new ArrayDeque<>();
            boolean isValid = true;
            
            for(int j = 0; j < len; j++) {
                char cur = array[(i + j) % len];
                
                if(cur == '(' || cur == '{' || cur == '[') {
                    dq.push(cur);
                } else {
                    if(dq.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    
                    char last = dq.pop();
                    if((last == '(' && cur != ')') 
                        || (last == '{' && cur != '}') 
                        || (last == '[' && cur != ']')) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            if(isValid && dq.isEmpty()) answer++;
        }
        
        
        return answer;
    }
}