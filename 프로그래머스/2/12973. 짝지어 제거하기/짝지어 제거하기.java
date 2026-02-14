import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> dq = new ArrayDeque<>();
        
        char[] ch = s.toCharArray();
        
        for(char c : ch){
            
            if(dq.isEmpty()){
                dq.push(c);
                continue;
            }
            
            if(dq.peek() == c) {
                dq.pop();
                continue;
            }
                
            dq.push(c);
            
        }

        return dq.isEmpty() ? 1 : 0;
    }
}