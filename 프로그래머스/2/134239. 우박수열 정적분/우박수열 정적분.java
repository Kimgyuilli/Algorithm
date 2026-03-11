import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> woobak = new ArrayList<>();
        woobak.add(k);
        
        while(k > 1) {
            if(k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            woobak.add(k);
        }
        
        int n = woobak.size() - 1;
        double[] areas = new double[n];
        
        for(int i = 0; i < n; i++) {
            areas[i] = (woobak.get(i) + woobak.get(i + 1)) / 2.0;
        }
        
        double[] answer = new double[ranges.length];
        
        for(int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            
            if(start > end) {
                answer[i] = -1.0;
            } else if (start == end) {
                answer[i] = 0.0;
            } else {
                double sum = 0;
                for(int j = start; j < end; j++) {
                    sum += areas[j];
                }
                answer[i] = sum;
            }
        }
        
        return answer;
    }
}