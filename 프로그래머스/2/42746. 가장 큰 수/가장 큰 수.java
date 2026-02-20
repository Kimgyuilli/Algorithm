import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (String s : strNums) {
            answer.append(s);
        }

        return answer.toString();
    }
}