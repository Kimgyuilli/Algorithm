import java.util.*;

class Solution {
    private int wordLen;
    public int solution(String begin, String target, String[] words) {
        int listLen = words.length;
        this.wordLen = target.length();
        
        int[] visited = new int[listLen];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < listLen; i++) {
            if(canMatch(begin, words[i])) {
                q.offer(i);
                visited[i] = 1;
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(words[cur].equals(target)) return visited[cur];
            
            for(int i = 0; i < listLen; i++) {
                if (visited[i] > 0 || !canMatch(words[cur], words[i])) continue;
                q.offer(i);
                visited[i] = visited[cur] + 1;
            }
        }
        
        return 0;
    }
    
    private boolean canMatch(String before, String after) {
        int count = 0;
        for(int i = 0; i < wordLen; i++) {
            if(before.charAt(i) != after.charAt(i)) count++;
            if(count >= 2) return false;
        }
        
        return true;
    }
    
}