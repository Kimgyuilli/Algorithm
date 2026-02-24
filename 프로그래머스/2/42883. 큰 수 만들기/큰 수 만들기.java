import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Deque<Character> stack = new ArrayDeque<>();
        int removed = 0;
        
        for(int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            
            while (removed < k && !stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
                removed++;
            }
            stack.push(cur);
        }
        
        while(removed < k) {
            stack.pop();
            removed++;
        }
        
        char[] result = new char[stack.size()];
        
        for(int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return String.valueOf(result);
    }
}