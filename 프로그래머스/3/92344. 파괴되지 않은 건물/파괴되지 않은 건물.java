class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        // 누적합을 기록할 배열 (인덱스 에러 방지를 위해 +1 크기로 생성)
        int[][] sum = new int[n + 1][m + 1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = (type == 1) ? -s[5] : s[5];

            // 4개의 지점에 마킹
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }

        // 가로 방향 누적합 계산
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        // 세로 방향 누적합 계산
        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        // 원본 보드와 합쳐서 결과 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}