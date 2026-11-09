class Solution {
    public int pivotInteger(int n) {

        int total = n * (n + 1) / 2;

        int cur = 0;
        for(int i = 1; i <= n; i++) {
            cur += i;

            if(cur == total - cur + i) return i;
        }

        return -1;
    }
}