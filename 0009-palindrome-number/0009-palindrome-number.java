class Solution {
    public boolean isPalindrome(int x) {
        // 음수, 그리고 0이 아니면서 10으로 나누어떨어지는 수(끝자리 0)는 팰린드롬 아님
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }

        // 자릿수가 짝수면 x == reverted, 홀수면 가운데 자리를 버린 x == reverted / 10
        return x == reverted || x == reverted / 10;
    }
}