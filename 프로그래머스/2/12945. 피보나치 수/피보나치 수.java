class Solution {
    public int solution(int n) {
        int pre = 0;
        int cur = 1;
        
        if (n == 0) return 0;
        if (n == 1) return 1;

        for (int i = 2; i <= n; i++) {
            int next = (pre + cur) % 1234567;
            pre = cur;
            cur = next;
        }
        
        return cur;
    }
}