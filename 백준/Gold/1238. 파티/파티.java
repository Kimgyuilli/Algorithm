import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int numCities, numOfRoads, partyLocation;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numCities = Integer.parseInt(st.nextToken());
        numOfRoads = Integer.parseInt(st.nextToken());
        partyLocation = Integer.parseInt(st.nextToken());

        distance = new int[numCities + 1][numCities + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= numCities; i++) {
            for (int j = 1; j <= numCities; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 입력 받기 및 간선 정보 업데이트 (최소값 저장)
        for (int i = 0; i < numOfRoads; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            distance[start][end] = Math.min(distance[start][end], cost);
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= numCities; k++) {
            for (int i = 1; i <= numCities; i++) {
                for (int j = 1; j <= numCities; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        if (distance[i][k] + distance[k][j] < distance[i][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
        }

        // 왕복 거리 계산
        int maxRoundTrip = Integer.MIN_VALUE;
        for (int i = 1; i <= numCities; i++) {
            if (distance[i][partyLocation] != Integer.MAX_VALUE && distance[partyLocation][i] != Integer.MAX_VALUE) {
                int roundTrip = distance[i][partyLocation] + distance[partyLocation][i];
                maxRoundTrip = Math.max(maxRoundTrip, roundTrip);
            }
        }

        System.out.println(maxRoundTrip);
    }
}
