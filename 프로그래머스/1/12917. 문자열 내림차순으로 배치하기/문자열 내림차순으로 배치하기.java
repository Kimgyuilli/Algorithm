import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String[] chars = s.split("");
        Arrays.sort(chars, Collections.reverseOrder());
        return String.join("", chars);
    }
}