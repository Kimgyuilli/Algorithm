import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        
        String[] s = sb.reverse().toString().split("");
        
        return Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
    }
}