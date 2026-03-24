import java.util.*;

class Solution {

    class Task {
        String name;
        int remain;
        Task(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {

        Arrays.sort(plans, (a, b) -> parseTime(a[1]) - parseTime(b[1]));

        Deque<Task> stop = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        
        int currentTime = 0;

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = parseTime(plans[i][1]);
            int play = Integer.parseInt(plans[i][2]);

            while (!stop.isEmpty() && currentTime < start) {
                Task paused = stop.pop();
                int gap = start - currentTime;

                if (paused.remain <= gap) {
                    currentTime += paused.remain;
                    result.add(paused.name);
                } else {
                    paused.remain -= gap;
                    stop.push(paused);
                    currentTime = start;
                }
            }

            currentTime = start;
            stop.push(new Task(name, play));
        }

        while (!stop.isEmpty()) {
            result.add(stop.pop().name);
        }

        return result.toArray(new String[0]);
    }

    private int parseTime(String timeStamp) {
        String[] part = timeStamp.split(":");
        return Integer.parseInt(part[0]) * 60 + Integer.parseInt(part[1]);
    }
}