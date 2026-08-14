class Solution {
    public int countDigits(int num) {

        if(num < 10) return 1;
        int compare = num;
        int answer = 0;
        while(compare > 0) {
            int cur = compare % 10;
            if(cur != 0 && num % cur == 0) {
                answer++;
            }

            compare /= 10;
        }
        return answer;
    }
}