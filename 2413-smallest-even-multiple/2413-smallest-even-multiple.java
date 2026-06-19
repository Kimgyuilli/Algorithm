class Solution {
    public int smallestEvenMultiple(int n) {
        return n * 2 / gcd(n, 2);
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}