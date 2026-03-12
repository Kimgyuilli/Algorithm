import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시간 순으로 정렬 (먼저 들어온 애들을 먼저 확인하기 위해)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 2. 소요 시간 순으로 뽑아주는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int totalResponseTime = 0;
        int currentTime = 0;
        int jobIdx = 0;
        int completedJobs = 0;

        // 모든 작업을 처리할 때까지 반복
        while (completedJobs < jobs.length) {
            
            // 3. 현재 시간(currentTime)까지 들어온 모든 요청을 PQ에 삽입
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                pq.offer(jobs[jobIdx++]);
            }

            if (pq.isEmpty()) {
                // 4. 기다리는 작업이 없다면, 다음 작업이 들어오는 시간으로 점프
                currentTime = jobs[jobIdx][0];
            } else {
                // 5. 소요 시간이 가장 짧은 작업을 꺼내서 처리
                int[] job = pq.poll();
                
                // 대기 시간 + 소요 시간 계산
                // 반환 시간 = (현재 시간 + 소요 시간) - 요청 시간
                totalResponseTime += (currentTime + job[1]) - job[0];
                
                // 시간 흐름 업데이트
                currentTime += job[1];
                completedJobs++;
            }
        }

        return totalResponseTime / jobs.length;
    }
}