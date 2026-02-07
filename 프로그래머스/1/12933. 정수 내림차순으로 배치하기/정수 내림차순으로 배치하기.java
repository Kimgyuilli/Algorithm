import java.util.*;

class Solution {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        
        StringBuilder sb = new StringBuilder(new String(chars));
        return Long.parseLong(sb.reverse().toString());
    }
}