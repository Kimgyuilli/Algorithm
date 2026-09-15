import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> decreasePq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> increasePq = new PriorityQueue<>();
        
        int count = 0;
        for(String operation : operations) {
            
            char oper = operation.charAt(0);
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            if(oper == 'I') {
                increasePq.offer(num);
                decreasePq.offer(num);
                count++;
                continue;
            }
            
            if(count == 0) continue;
            if(num == 1) { 
                increasePq.remove(decreasePq.poll());
            }
            else {
                decreasePq.remove(increasePq.poll());   
            }
            count--;
            
        }
        
        if(count == 0) return new int[] {0, 0};
        if(count == 1) {
            int val = increasePq.peek();
            return new int[] {val, val};
        }
        
        
        return new int[] {decreasePq.poll(), increasePq.poll()};
    }
}