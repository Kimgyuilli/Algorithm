class Solution {
    public int minOperations(int n) {

        int answer = 0;
        int left = 1;
        int right = n * 2 - 1;

        while(left < right) {
            answer += right - left;
            left += 2;
            right -= 2;
        }
        return answer / 2;
    }
}
