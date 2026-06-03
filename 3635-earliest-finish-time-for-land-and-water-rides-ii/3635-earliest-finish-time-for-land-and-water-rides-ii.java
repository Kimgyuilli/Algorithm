import java.util.*;

class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {
        RideHelper land = new RideHelper(landStartTime, landDuration);
        RideHelper water = new RideHelper(waterStartTime, waterDuration);

        long answer = Long.MAX_VALUE;

        // land 먼저, water 나중
        for (int i = 0; i < landStartTime.length; i++) {
            long landEnd = (long) landStartTime[i] + landDuration[i];
            answer = Math.min(answer, water.bestFinishAfter(landEnd));
        }

        // water 먼저, land 나중
        for (int i = 0; i < waterStartTime.length; i++) {
            long waterEnd = (long) waterStartTime[i] + waterDuration[i];
            answer = Math.min(answer, land.bestFinishAfter(waterEnd));
        }

        return (int) answer;
    }

    static class RideHelper {
        int n;
        int[] start;
        int[] prefixMinDuration;
        long[] suffixMinEnd;

        RideHelper(int[] starts, int[] durations) {
            n = starts.length;

            int[][] rides = new int[n][2];
            for (int i = 0; i < n; i++) {
                rides[i][0] = starts[i];
                rides[i][1] = durations[i];
            }

            Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

            start = new int[n];
            prefixMinDuration = new int[n];
            suffixMinEnd = new long[n];

            for (int i = 0; i < n; i++) {
                start[i] = rides[i][0];
                prefixMinDuration[i] = rides[i][1];

                if (i > 0) {
                    prefixMinDuration[i] = Math.min(prefixMinDuration[i], prefixMinDuration[i - 1]);
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                suffixMinEnd[i] = (long) rides[i][0] + rides[i][1];

                if (i + 1 < n) {
                    suffixMinEnd[i] = Math.min(suffixMinEnd[i], suffixMinEnd[i + 1]);
                }
            }
        }

        long bestFinishAfter(long currentTime) {
            int idx = upperBound(start, currentTime);

            long result = Long.MAX_VALUE;

            // start <= currentTime 인 놀이기구
            // 기다릴 필요 없음: currentTime + duration
            if (idx > 0) {
                result = Math.min(result, currentTime + prefixMinDuration[idx - 1]);
            }

            // start > currentTime 인 놀이기구
            // 기다려야 함: start + duration
            if (idx < n) {
                result = Math.min(result, suffixMinEnd[idx]);
            }

            return result;
        }

        int upperBound(int[] arr, long target) {
            int left = 0;
            int right = arr.length;

            while (left < right) {
                int mid = (left + right) / 2;

                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}