import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 1. 크루 도착 시간을 분 단위로 변환하여 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            String[] part = time.split(":");
            pq.add(Integer.parseInt(part[0]) * 60 + Integer.parseInt(part[1]));
        }

        int busTime = 9 * 60;
        int lastCrewTime = 0;
        int totalCrewsInBus = 0;

        // 2. n번의 버스 운행 시뮬레이션
        for (int i = 0; i < n; i++) {
            totalCrewsInBus = 0;
            
            // 현재 버스 시간에 대기 중인 크루들을 최대 m명 태움
            while (!pq.isEmpty() && pq.peek() <= busTime && totalCrewsInBus < m) {
                lastCrewTime = pq.poll();
                totalCrewsInBus++;
            }

            // 마지막 버스가 아니라면 다음 버스 시간으로 업데이트
            if (i < n - 1) busTime += t;
        }

        // 3. 정답 계산 (마지막 버스 기준)
        int answerTime = 0;
        if (totalCrewsInBus < m) {
            // 자리가 남았다면 버스 출발 시간에 맞춰 감
            answerTime = busTime;
        } else {
            // 자리가 없다면 마지막으로 탄 사람보다 1분 빨리 감
            answerTime = lastCrewTime - 1;
        }

        // 4. HH:mm 형식으로 변환
        return String.format("%02d:%02d", answerTime / 60, answerTime % 60);
    }
}