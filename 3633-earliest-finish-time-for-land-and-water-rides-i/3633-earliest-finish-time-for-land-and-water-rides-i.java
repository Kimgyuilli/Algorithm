class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landLen = landStartTime.length;
        int waterLen = waterStartTime.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < landLen; i++) {
            for(int j = 0; j < waterLen; j++) {
                int finish1 = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
                int finish2 = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];

                min = Math.min(min, Math.min(finish1, finish2));
            }
        }
        return min;
    }
}