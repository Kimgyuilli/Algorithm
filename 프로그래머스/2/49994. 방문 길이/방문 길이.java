import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        Set<String> set = new HashSet<>();
        
        int answer = 0;
        char[] ch = dirs.toCharArray();
        int x = 0, y = 0;
        
        for(char c : ch){
            int nx = x;
            int ny = y;
            switch(c){
                case 'L':
                    nx -= 1;
                    break;
                case 'R':
                    nx += 1;
                    break;
                case 'U':
                    ny += 1;
                    break;
                case 'D':
                    ny -= 1;
                    break;
            }
            
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) continue;
                
            String path1 = x + "," + y + ">" + nx + "," + ny;
            String path2 = nx + "," + ny + ">" + x + "," + y;
            
            if(!set.contains(path1)){
                set.add(path1);
                set.add(path2);
                answer++;
            }
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}