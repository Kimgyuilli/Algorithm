class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder gameStr = new StringBuilder();
        int num = 0;

        while (gameStr.length() < t * m) {
            gameStr.append(Integer.toString(num++, n).toUpperCase());
        }

        for (int i = 0; i < t; i++) {
            answer.append(gameStr.charAt((p - 1) + (i * m)));
        }

        return answer.toString();
    }
}