import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Arrays.sort(dice);
        
        // 모두 같음
        if (dice[0] == dice[3]) {
            return 1111 * dice[0];
        }
        
        // 3개 같음
        if (dice[0] == dice[2] || dice[1] == dice[3]) {
            int p = dice[1]; // 중간값이 3개 중 하나
            int q = (dice[0] == dice[2]) ? dice[3] : dice[0];
            return (10 * p + q) * (10 * p + q);
        }
        
        // 2개씩 같음
        if (dice[0] == dice[1] && dice[2] == dice[3]) {
            return (dice[0] + dice[2]) * Math.abs(dice[0] - dice[2]);
        }
        
        // 2개만 같음
        if (dice[0] == dice[1] || dice[1] == dice[2] || dice[2] == dice[3]) {
            int result = 1;
            for (int i = 0; i < 4; i++) {
                if ((i == 0 || dice[i] != dice[i-1]) && 
                    (i == 3 || dice[i] != dice[i+1])) {
                    result *= dice[i];
                }
            }
            return result;
        }
        
        // 모두 다름
        return dice[0];
    }
}