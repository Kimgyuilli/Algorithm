class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            storey /= 10;

            if (cur > 5 || (cur == 5 && next >= 5)) {
                storey += 1;
                answer += 10 - cur;
            } else {
                answer += cur;
            }
        }
        
        return answer;
    }
}