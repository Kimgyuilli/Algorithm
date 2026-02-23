import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        
        int current_weight = 0;
        
        int truck_idx = 0;
        int answer = 0;
        while(!queue.isEmpty()) {
            answer++;
            current_weight -= queue.peek();
            queue.poll();
            
            if(truck_idx == truck_weights.length) continue;
            
            if(current_weight + truck_weights[truck_idx] > weight) {
                queue.offer(0);
            } else {
                queue.offer(truck_weights[truck_idx]);
                current_weight += truck_weights[truck_idx];
                truck_idx++;
            }
        }
        
        return answer;
    }
}