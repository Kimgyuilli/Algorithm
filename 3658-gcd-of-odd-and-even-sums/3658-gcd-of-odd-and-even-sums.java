class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n*n;
        int sumEven = n*(+1);

        return GCD(sumOdd, sumEven);
    }

    private int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}