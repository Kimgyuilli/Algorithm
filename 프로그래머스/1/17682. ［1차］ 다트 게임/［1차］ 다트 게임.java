class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int round = -1;
        int i = 0;
        
        while(i < dartResult.length()) {
            char c = dartResult.charAt(i);
            
            // 숫자 파싱
            if(Character.isDigit(c)) {
                round++;
                int score = c - '0';
                if(i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++;
                }
                scores[round] = score;
            }
            // 보너스
            else if(c == 'S') { /* 1승 - 변환 불필요 */ }
            else if(c == 'D') { scores[round] *= scores[round]; }
            else if(c == 'T') { scores[round] = scores[round] * scores[round] * scores[round]; }
            // 옵션
            else if(c == '*') {
                scores[round] *= 2;
                if(round > 0) scores[round - 1] *= 2;
            }
            else if(c == '#') {
                scores[round] *= -1;
            }
            
            i++;
        }
        
        return scores[0] + scores[1] + scores[2];
    }
}