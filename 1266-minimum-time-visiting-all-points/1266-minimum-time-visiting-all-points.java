class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int answer = 0;

        for(int i = 1; i < points.length; i++) {
            int diffX = Math.abs(points[i-1][0] - points[i][0]);
            int diffY = Math.abs(points[i-1][1] - points[i][1]);

            int a = Math.abs(diffX - diffY);

            answer +=  Math.max(diffX, diffY);
        }

        return answer;
    }
}