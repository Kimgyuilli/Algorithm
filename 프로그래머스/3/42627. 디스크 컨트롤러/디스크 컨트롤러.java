import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 우선순위 큐: 소요 시간(index 2)이 짧은 순으로
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // 2. 인덱싱 및 요청 시간순 정렬
        int[][] indexed_jobs = new int[jobs.length][3];
        for(int i = 0; i < jobs.length; i++) {
            indexed_jobs[i][0] = i;       // 원래 번호
            indexed_jobs[i][1] = jobs[i][0]; // 요청 시간
            indexed_jobs[i][2] = jobs[i][1]; // 소요 시간
        }

        Arrays.sort(indexed_jobs, (a, b) -> a[1] - b[1]);

        int time = 0;
        int index = 0;
        int workLeft = 0; // 현재 작업의 남은 시간
        int totalResponseTime = 0;
        int completedJobs = 0;

        // 모든 작업이 완료될 때까지 반복
        while (completedJobs < jobs.length) {
            
            // 3.1 현재 시간(time)에 딱 맞춰 들어온 작업들을 PQ에 삽입
            while (index < jobs.length && indexed_jobs[index][1] <= time) {
                pq.offer(indexed_jobs[index++]);
            }

            // 3.2 수행 중인 작업이 없고, 대기 중인 작업이 있다면 새로 시작
            if (workLeft == 0 && !pq.isEmpty()) {
                int[] cur = pq.poll();
                // [수정] 반환 시간 = (현재 시간 + 소요 시간) - 요청 시간
                totalResponseTime += (time + cur[2]) - cur[1];
                workLeft = cur[2];
                completedJobs++;
            }

            // 3.3 시간 흐름 관리
            if (workLeft > 0) {
                workLeft--;
                time++;
            } else {
                // 수행 중인 작업도 없고 PQ도 비어있다면, 다음 작업이 올 때까지 시간만 보냄
                time++;
            }
        }

        return totalResponseTime / jobs.length;
    }
}