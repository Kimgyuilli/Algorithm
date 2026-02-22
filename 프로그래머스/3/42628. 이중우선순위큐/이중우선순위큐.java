import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        
        int add = 0;
        int poll = 0;
        for(String operation : operations) {
            String[] operator = operation.split(" ");
            int num = Integer.parseInt(operator[1]);
            
            if(operator[0].equals("I")) {
                minPq.offer(num);
                maxPq.offer(num);
                add++;
            } else {
                if(add - poll == 0) continue;
                if(num > 0) {
                    minPq.remove(maxPq.poll());
                } else {
                    maxPq.remove(minPq.poll());
                }
                poll++;
            }
        }
        
        if (add == poll) return new int[]{0, 0};
        if (add - poll == 1) {
            int val = minPq.peek();
            return new int[]{val, val};
        }
        
        
        return new int[]{maxPq.peek(), minPq.peek()};
    }
}