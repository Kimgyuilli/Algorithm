class Solution {
    public int solution(int n) {
        
        int pre = 0;
        int cur = 1;
        
        for(int i = 2; i <= n; i++) {
            int temp = cur;
            cur = (pre + cur) % 1234567;
            pre = temp;
        }
        
        return cur;
    }
}