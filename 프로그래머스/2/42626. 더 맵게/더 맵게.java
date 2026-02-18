import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.add(s);
        }
        
        while (heap.peek() < K) {
            if (heap.size() < 2) {
                return -1;
            }
            
            int first = heap.poll();
            int second = heap.poll();
            
            int mixed = first + (second * 2);
            heap.add(mixed);
            
            answer++;
        }
        
        return answer;
    }
}