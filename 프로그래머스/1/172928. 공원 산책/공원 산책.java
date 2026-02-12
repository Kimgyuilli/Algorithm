import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int r = park.length;
        int c = park[0].length();
        int curY = 0, curX = 0;

        for (int i = 0; i < r; i++) {
            if (park[i].contains("S")) {
                curY = i;
                curX = park[i].indexOf("S");
                break;
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            String dir = parts[0];
            int dist = Integer.parseInt(parts[1]);

            int nextY = curY;
            int nextX = curX;
            boolean canMove = true;
            
            for (int i = 0; i < dist; i++) {
                if (dir.equals("N")) nextY--;
                else if (dir.equals("S")) nextY++;
                else if (dir.equals("W")) nextX--;
                else if (dir.equals("E")) nextX++;

                if (nextY < 0 || nextY >= r || nextX < 0 || nextX >= c || park[nextY].charAt(nextX) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                curY = nextY;
                curX = nextX;
            }
        }

        return new int[]{curY, curX};
    }
}