import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int cur_room = 0;
        int answer = 0;
        
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for(String[] reserve : book_time) {
            String[] check_in = reserve[0].split(":");
            String[] check_out = reserve[1].split(":");
            
            int in = Integer.parseInt(check_in[0]) * 60 + Integer.parseInt(check_in[1]);
            int out = Integer.parseInt(check_out[0]) * 60 + Integer.parseInt(check_out[1]) + 10;
            if(pq.isEmpty()) {
                pq.offer(out);
                answer = Math.max(1, answer);
                continue;
            }
            
            while(!pq.isEmpty() && pq.peek() <= in) {
                pq.poll();
            }
            
            pq.offer(out);
            System.out.println(pq.size() + " " + in + " " + out);
            answer = Math.max(pq.size(), answer);
        }
        
        return answer;
    }
}