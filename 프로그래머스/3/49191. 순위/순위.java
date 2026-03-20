class Solution {
    public int solution(int n, int[][] results) {
        // 승패 관계를 저장할 인접 행렬
        boolean[][] win = new boolean[n + 1][n + 1];

        for (int[] res : results) {
            win[res[0]][res[1]] = true; // res[0]이 res[1]을 이김
        }

        // 플로이드-워셜: 거쳐가는 노드(k)를 기준으로 승패 전이 확인
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i가 k를 이기고, k가 j를 이겼다면 -> i는 j를 이김
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                // i가 j를 이겼거나, j가 i를 이긴 경우(즉, 승패 관계가 확실한 경우)
                if (win[i][j] || win[j][i]) {
                    count++;
                }
            }
            // 자신을 제외한 n-1명과 승패 관계가 확실하다면 순위 확정
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}