class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if (n % 2 == 0) {
                answer[i] = n + 1;
            } else {
                // 가장 낮은 0비트 위치 찾기
                long bit = ~n & (n + 1); // lowest 0-bit
                // 해당 비트를 1로 켜고, 바로 아래 비트를 0으로 끔
                answer[i] = n | bit;              // 0→1
                answer[i] &= ~(bit >> 1);         // 그 아래 1→0
            }
        }

        return answer;
    }
}