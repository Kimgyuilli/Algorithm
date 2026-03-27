class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1_sq = (long) r1 * r1;
        long r2_sq = (long) r2 * r2;

        for (int x = 1; x <= r2; x++) {
            long x_sq = (long) x * x;
            
            // r2 원의 y
            long y2 = (long) Math.sqrt(r2_sq - x_sq);
            
            // r1 원의 y
            long y1 = 0;
            if (x < r1) {
                double sqrt1 = Math.sqrt(r1_sq - x_sq);
                y1 = (long) sqrt1;
                
                // 정수가 아니면 올림
                if (sqrt1 > y1) { 
                    y1++; 
                }
            }
            
            answer += (y2 - y1 + 1);
        }

        // 1사분면 개수 * 4 (축 위의 점들은 x=1부터 시작했으므로 자동으로 포함됨)
        return answer * 4;
    }
}