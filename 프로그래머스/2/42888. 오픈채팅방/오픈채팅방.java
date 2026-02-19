import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, String> user = new HashMap<>();
        Deque<String> log = new ArrayDeque<>();

        for (String r : record) {
            String[] event = r.split(" ");

            if (event[0].charAt(0) == 'E') {
                user.put(event[1], event[2]);
                log.offer("E" + event[1]);
            } else if (event[0].charAt(0) == 'L') {
                log.offer("L" + event[1]);
            } else {
                user.put(event[1], event[2]);
            }
        }

        String[] answer = new String[log.size()];

        for (int i = 0; i < answer.length; i++) {
            String cur = log.poll();
            String name = user.get(cur.substring(1));

            if (cur.charAt(0) == 'E') {
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}