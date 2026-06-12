class Solution {
    public int mirrorDistance(int n) {
        int temp = n;
        long reversed = 0;
        while(temp > 0) {
            reversed += temp % 10;
            temp /= 10;
            reversed *= 10;
        }

        reversed /= 10;

        return (int)Math.abs(n - reversed);
    }
}