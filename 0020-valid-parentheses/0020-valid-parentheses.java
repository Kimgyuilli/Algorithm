import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();


        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(cur == ')' || cur == '}' || cur == ']') {
                
                if(dq.peek() == null) return false;
                char pre = dq.pop();
                if((cur == ')' && pre == '(') || (cur == ']' && pre == '[') || (cur == '}' && pre == '{')) {
                    continue;
                } else {
                    return false;
                } 
            }
            dq.push(cur);
        }

        return dq.isEmpty() ? true : false;
    }
}