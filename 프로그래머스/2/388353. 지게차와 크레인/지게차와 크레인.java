import java.util.*;

class Solution {
    int answer;
    char[][] containers;
    boolean[][] isEdge;
    int height, width;
    
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        width = storage[0].length();
        height = storage.length;
        
        containers = new char[height][width];
        for (int i = 0; i < height; i++) {
            containers[i] = storage[i].toCharArray();
        }
        
        isEdge = new boolean[height + 2][width + 2];
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (i == 0 || j == 0 || i == height + 1 || j == width + 1) {
                    isEdge[i][j] = true;
                }
            }
        }
        
        answer = width * height;
        
        for (String request : requests) {
            char find = request.charAt(0);
            boolean isFork = request.length() == 1;
            
            if (isFork) {
                getEdgeContainer(find);
            } else {
                getAllContainer(find);
            }
        }
        
        return answer;
    }
    
    // 지게차: 엣지에 접근 가능한 컨테이너만 제거
    private void getEdgeContainer(char find) {
        List<int[]> toRemove = new ArrayList<>();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (containers[i][j] != find) continue;
                if (isEdge(i + 1, j + 1)) {
                    toRemove.add(new int[]{i, j});
                }
            }
        }
        
        // 수집된 위치 일괄 제거 후 엣지 전파
        for (int[] pos : toRemove) {
            containers[pos[0]][pos[1]] = '0';
            answer--;
            spreadEdge(pos[0] + 1, pos[1] + 1);
        }
    }
    
    // 크레인: 모든 해당 컨테이너 제거
    private void getAllContainer(char find) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (containers[i][j] != find) continue;
                containers[i][j] = '0';
                answer--;
                spreadEdge(i + 1, j + 1);
            }
        }
    }
    
    // 현재 위치가 외부와 인접한지 확인
    private boolean isEdge(int y, int x) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (isEdge[ny][nx]) return true;
        }
        return false;
    }
    
    // 빈 공간('0') 기준으로 BFS를 통해 외부 연결 정보 전파
    private void spreadEdge(int y, int x) {
        if (!isEdge(y, x)) return;
        
        isEdge[y][x] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if (ny < 1 || nx < 1 || ny > height || nx > width) continue;
                if (isEdge[ny][nx]) continue;
                // 빈 공간이고 아직 외부 연결 안 된 경우 전파
                if (containers[ny - 1][nx - 1] == '0') {
                    isEdge[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}