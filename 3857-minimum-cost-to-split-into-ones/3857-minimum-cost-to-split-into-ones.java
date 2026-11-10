class Solution {
    public int minCost(int n) {
        if(n == 1) return 0;

        int a = (n / 2) + n % 2;
        int b = n / 2;

        int cost = a * b;
        
        return cost + minCost(a) + minCost(b);
    }
}