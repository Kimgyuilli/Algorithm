import java.util.*;

class Solution {
    private static final int LAST_TIME = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        int baseDuration = fees[0];
        int baseFee = fees[1];
        int unitDuration = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> totalTime = new TreeMap<>();   // 차량별 누적 주차 시간
        Map<String, Integer> entryTime = new HashMap<>();   // 차량별 마지막 입차 시간

        for (String record : records) {
            String[] log = record.split(" ");
            int time = toMinutes(log[0]);
            String carNumber = log[1];
            String type = log[2];

            if (type.equals("IN")) {
                entryTime.put(carNumber, time);
            } else {
                int parked = time - entryTime.remove(carNumber);
                totalTime.merge(carNumber, parked, Integer::sum);
            }
        }

        // 미출차 차량 처리
        for (var entry : entryTime.entrySet()) {
            int parked = LAST_TIME - entry.getValue();
            totalTime.merge(entry.getKey(), parked, Integer::sum);
        }

        // 요금 계산
        return totalTime.values().stream()
                .mapToInt(time -> calculateFee(time, baseDuration, baseFee, unitDuration, unitFee))
                .toArray();
    }

    private int toMinutes(String timeStr) {
        return Integer.parseInt(timeStr.substring(0, 2)) * 60
             + Integer.parseInt(timeStr.substring(3, 5));
    }

    private int calculateFee(int time, int baseDuration, int baseFee, int unitDuration, int unitFee) {
        if (time <= baseDuration) return baseFee;
        int overTime = time - baseDuration;
        return baseFee + (int) Math.ceil((double) overTime / unitDuration) * unitFee;
    }
}