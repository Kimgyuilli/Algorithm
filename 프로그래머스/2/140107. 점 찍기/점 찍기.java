class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dLong = (long)d;

        for (long x = 0; x <= dLong; x += k) {
            long yMax = (long) Math.sqrt(dLong * dLong - x * x);
            
            answer += (yMax / k) + 1;
        }

        return answer;
    }
}