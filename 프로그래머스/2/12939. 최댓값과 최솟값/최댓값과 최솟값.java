import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sp = s.split(" ");
        
        Arrays.sort(sp, (a, b) -> {
            return Integer.parseInt(a) - Integer.parseInt(b);
        });
        
        return Integer.parseInt(sp[0]) + " " + Integer.parseInt(sp[sp.length - 1]);
    }
}