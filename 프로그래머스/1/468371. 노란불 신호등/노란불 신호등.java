class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] cycles = new int[n];
        
        for (int i = 0; i < n; i++) {
            cycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        long maxTime = cycles[0];
        for (int i = 1; i < n; i++) {
            maxTime = lcm(maxTime, cycles[i]);
        }
        
        for (long t = 1; t <= maxTime; t++) {
            boolean allYellow = true;
            
            for (int i = 0; i < n; i++) {
                int G = signals[i][0];
                int Y = signals[i][1];
                int T = cycles[i];
                
                long tMod = t % T;
                if (tMod == 0) tMod = T;
                
                if (tMod <= G || tMod > G + Y) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return (int) t;
            }
        }
        
        return -1;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}