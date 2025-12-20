import java.util.*;

class Solution {
    public String solution(String s) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            
            if(num < min) min = num;
            if(num > max) max = num;
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(min).append(' ').append(max);
        return sb.toString();
        
    }
}