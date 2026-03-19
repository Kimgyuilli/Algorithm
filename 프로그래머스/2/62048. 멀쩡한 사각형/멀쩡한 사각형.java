class Solution {
    public long solution(int w, int h) {
        long answer = 0;

        for (long x = 1; x < w; x++) {
            answer += (long) h * x / w;
        }

        return answer * 2;
    }
}