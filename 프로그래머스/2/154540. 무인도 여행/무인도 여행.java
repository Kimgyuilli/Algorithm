import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[] maps) {
        List<Integer> islands = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int sum = dfs(maps, visited, i, j);
                    islands.add(sum);
                }
            }
        }
        
        if (islands.isEmpty()) {
            return new int[]{-1};
        }
        
        return islands.stream()
                     .mapToInt(Integer::intValue)
                     .sorted()
                     .toArray();
    }
    
    private int dfs(String[] maps, boolean[][] visited, int x, int y) {
        // 경계 검사 및 방문 여부 검사
        if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length() 
            || maps[x].charAt(y) == 'X' || visited[x][y]) {
            return 0;
        }
        
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';
        
        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            sum += dfs(maps, visited, x + dx[i], y + dy[i]);
        }
        
        return sum;
    }
}