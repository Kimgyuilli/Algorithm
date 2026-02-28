import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();
    boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        dfs(user_id, banned_id, 0);
        
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int depth) {
        if(depth == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) sb.append(i);
            }
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i] && isMatch(user_id[i], banned_id[depth])) {
                visited[i] = true;
                dfs(user_id, banned_id, depth + 1);
                visited[i] = false;
            }
        }
    }
    private boolean isMatch(String a, String b) {
        if(a.length() != b.length()) return false;
        for(int i = 0; i < a.length(); i++) {
            if(b.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i)) return false;
        }
        
        return true;
    }
    
}