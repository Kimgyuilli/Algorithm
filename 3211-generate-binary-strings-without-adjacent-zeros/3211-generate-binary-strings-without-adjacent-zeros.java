import java.util.*;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int n, StringBuilder sb, List<String> result) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        sb.append('1');
        backtrack(n, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '0') {
            sb.append('0');
            backtrack(n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}