import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean[] selected;
    static int minCityDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new Point(i, j));
                else if (map[i][j] == 2) chickens.add(new Point(i, j));
            }
        }

        selected = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(minCityDistance);
    }

    static void dfs(int start, int count) {
        if (count == m) {
            int cityDistance = 0;
            for (Point house : houses) {
                int houseDistance = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (selected[i]) {
                        Point chicken = chickens.get(i);
                        houseDistance = Math.min(houseDistance,
                                Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
                    }
                }
                cityDistance += houseDistance;
            }
            minCityDistance = Math.min(minCityDistance, cityDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
