class Solution {
    public int pivotInteger(int n) {

        int total = 0;

        for(int i = 1; i <= n; i++) {
            total += i;
        }

        int cur = 0;
        for(int i = 1; i <= n; i++) {
            cur += i;

            if(cur == total - cur + i) return i;
        }

        return -1;
    }
}