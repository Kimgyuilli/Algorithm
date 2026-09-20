import java.util.*;

class Solution {
    private Set<String> result;
    private boolean[] visited;
    private String[] user_id;
    private String[] banned_id;
    private int userLen;
    private int banLen;
    public int solution(String[] user_id, String[] banned_id) {
        this.result = new HashSet<>();
        this.user_id = user_id;
        this.banned_id = banned_id;
        this.userLen = user_id.length;
        this.banLen = banned_id.length;
        visited = new boolean[userLen];
        
        DFS(0);
        
        return result.size();
    }
    
    private void DFS(int depth) {
        if(depth == banLen) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) sb.append(i);
            }
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i < userLen; i++) {
            if(!visited[i] && isMatch(user_id[i], banned_id[depth])) {
                visited[i] = true;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isMatch(String u, String b) {
        int len = u.length();
        if(len != b.length()) return false;
        for(int i = 0; i < len; i++) {
            if(b.charAt(i) == '*') continue;
            if(b.charAt(i) != u.charAt(i)) return false;
        }
        return true;
    }
}