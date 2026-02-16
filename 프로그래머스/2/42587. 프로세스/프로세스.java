import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 인덱스와 우선순위를 함께 관리할 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]}); // {원래 위치, 우선순위}
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;

            // 2. 현재 큐에 더 높은 우선순위가 있는지 확인
            for (int[] process : queue) {
                if (process[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 3. 더 높은게 있으면 다시 뒤로 넣기
                queue.add(current);
            } else {
                // 4. 실행하기 (실행 순서 증가)
                answer++;
                // 만약 방금 실행한게 내가 찾는 위치라면 종료
                if (current[0] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}