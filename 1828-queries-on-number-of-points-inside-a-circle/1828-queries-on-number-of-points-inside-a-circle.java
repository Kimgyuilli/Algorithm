class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            for(int[] point : points) {
                if(computeQuery(x, y, r, point[0], point[1])) {
                    result[i]++;
                }
            }
        }
        return result;
    }
    
    private boolean computeQuery(int qx, int qy, int qr, int px, int py) {
        int xdistance = Math.abs(qx - px);
        int ydistance = Math.abs(qy - py);
        int distance = xdistance * xdistance + ydistance * ydistance;

        if(distance > qr * qr) {
            return false;
        }
        return true;
    }
}