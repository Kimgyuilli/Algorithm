class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int cur = 0;
        int answer = 0;
        for(int floor : requests) {
            answer += Math.abs(cur - floor);
            cur = floor;
        }

        return answer;
    }
}