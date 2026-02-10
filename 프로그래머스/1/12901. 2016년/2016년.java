class Solution {
    public String solution(int a, int b) {
        
        final int[] SUM_OF_MONTH = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        final String[] WEEK = {"SUN", "MON", "TUE", "WED","THU", "FRI", "SAT"};
        
        int dayAfter = SUM_OF_MONTH[a - 1] + b;
        
        return WEEK[(dayAfter + 4) % 7];
    }
}