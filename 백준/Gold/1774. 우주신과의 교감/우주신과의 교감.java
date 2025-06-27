import java.io.*;
import java.util.*;

// 좌표를 표현하는 클래스
class Point {
    int num;        // 정점 번호
    double x, y;    // 좌표

    public Point(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

// 간선을 표현하는 클래스
class Edge implements Comparable<Edge> {
    int start, end;    // 시작 정점, 끝 정점
    double weight;     // 두 정점 간 거리 (가중치)

    Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    // 거리 기준으로 정렬 (오름차순)
    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}

public class Main {

    static int N, M; // N: 정점 수, M: 이미 연결된 간선 수
    static int[] parent; // 유니온-파인드를 위한 부모 배열
    static ArrayList<Edge> edgeList; // 모든 간선을 저장하는 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점 수와 기존 간선 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 부모 초기화 (자기 자신이 부모)
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 각 정점의 좌표 정보 입력
        Point[] points = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i, x, y);
        }

        // 이미 연결된 간선 처리 (union 수행)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        // 가능한 모든 간선(거리 계산)을 리스트에 저장
        edgeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = distance(points[i], points[j]);
                edgeList.add(new Edge(i, j, dist));
            }
        }

        // 거리 기준으로 간선 정렬
        Collections.sort(edgeList);

        // 크루스칼 알고리즘 실행
        double total = 0;
        for (Edge edge : edgeList) {
            // 서로 다른 집합이면 연결 (사이클 방지)
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                total += edge.weight; // 거리 누적
            }
        }

        // 결과 출력 (소수점 둘째 자리까지)
        System.out.printf("%.2f\n", total);
    }

    // 두 점 사이의 거리 계산 함수
    static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    // 유니온-파인드: 대표 노드 찾기 (경로 압축 포함)
    static int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]); // 경로 압축
        return parent[x];
    }

    // 두 집합을 합침
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
}
