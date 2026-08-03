class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int rr = queries[i][2]*queries[i][2];

            for(int[] point : points) {
                int xd = queries[i][0] - point[0];
                int yd = queries[i][1] - point[1];
                int distance = xd * xd + yd * yd;

                if(distance <= rr) {
                    result[i]++;
                }
            }
        }
        return result;
    }

}