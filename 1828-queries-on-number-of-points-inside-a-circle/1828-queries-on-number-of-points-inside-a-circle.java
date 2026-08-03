class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            int rr = r*r;

            for(int[] point : points) {
                int xd = x - point[0];
                int yd = y - point[1];
                int distance = xd * xd + yd * yd;

                if(distance <= rr) {
                    result[i]++;
                }
            }
        }
        return result;
    }

}