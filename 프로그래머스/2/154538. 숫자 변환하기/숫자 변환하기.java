import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {        
        if(x == y) return 0;
        
        boolean[] visited = new boolean[y+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, 0});
        visited[x] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int val = cur[0];
            int count =cur[1];
            
            for(int next : new int[]{val*2, val*3, val+n}) {
                if(next == y) return count + 1;
                if(next < y && !visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, count+1});
                }
            }
        }
        
        return -1;
    }
}