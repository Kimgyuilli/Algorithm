class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int answer = 0;

        if (cannotDivideAny(gcdA, arrayB)) answer = Math.max(answer, gcdA);

        if (cannotDivideAny(gcdB, arrayA)) answer = Math.max(answer, gcdB);

        return answer;
    }

    private boolean cannotDivideAny(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}