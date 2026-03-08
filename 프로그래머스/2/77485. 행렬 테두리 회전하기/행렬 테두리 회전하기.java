class Solution {
    int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {

        map = new int[rows][columns];
        int num = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, 
                               queries[i][2] - 1, queries[i][3] - 1);
        }
        return answer;
    }
    
     private int rotate(int x1, int y1, int x2, int y2) {
        int temp = map[x1][y1];
        int min = temp;

        // 1. 왼쪽 변: 아래에서 위로 올리기
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        // 2. 밑변: 오른쪽에서 왼쪽으로 밀기
        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }

        // 3. 오른쪽 변: 위에서 아래로 내리기
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }

        // 4. 윗변: 왼쪽에서 오른쪽으로 밀기
        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }

        // 보관했던 temp를 시작점의 바로 오른쪽 칸에 배치
        map[x1][y1 + 1] = temp;

        return min; // 회전한 숫자 중 가장 작은 값 반환
    }
}   