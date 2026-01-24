import java.lang.StringBuilder;
import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        
        StringBuilder sb = new StringBuilder();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            
            if(num > max){
                max = num;
            } 
            if(num < min) {
                min = num;
            }
            
        }
        
        return sb.append(min + " " + max).toString();
        
    }
}