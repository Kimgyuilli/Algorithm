import java.io.*;
import java.util.*;

public class Main {
    // 시계는 360,000단위로 나뉜 원형 형태 (정수 연산을 위해 일반적인 360도가 아닌 360000 사용)
    static final int MAX_ANGLE = 360000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 바늘 개수

        int[] a = new int[n]; // 시계 A의 바늘 위치
        int[] b = new int[n]; // 시계 B의 바늘 위치

        // 시계 A 바늘 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        // 시계 B 바늘 위치 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());

        // 각 시계의 바늘 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        // 두 시계의 간격 배열
        int[] diffA = getDiffArray(a, n); // 시계 A의 바늘 간격
        int[] diffB = getDiffArray(b, n); // 시계 B의 바늘 간격

        // 시계 A를 회전하는 모든 경우를 고려하기 위해 diffA를 두 번 이어붙임
        int[] extendedA = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extendedA[i] = diffA[i];
            extendedA[i + n] = diffA[i]; // 원형 비교를 위해 연속 두 번 복사
        }

        // KMP 알고리즘으로 diffB가 extendedA의 부분 배열로 존재하는지 확인
        boolean match = kmpMatch(extendedA, diffB);

        // 결과 출력
        System.out.println(match ? "possible" : "impossible");
    }

    /**
     * 바늘 위치 배열을 바탕으로 간격 배열을 구하는 함수
     * 시계는 원형이므로 마지막 바늘과 첫 바늘의 차도 포함
     */
    static int[] getDiffArray(int[] arr, int n) {
        int[] diff = new int[n];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i]; // 다음 바늘과의 각도 차
        }
        // 마지막 바늘과 첫 바늘 간의 차이 (원형이므로 360000을 더해서 양수로 만들어줌)
        diff[n - 1] = arr[0] + MAX_ANGLE - arr[n - 1];
        return diff;
    }

    /**
     * KMP 알고리즘을 사용하여 pattern(diffB)이 text(extendedA)에 포함되는지 검사
     */
    static boolean kmpMatch(int[] text, int[] pattern) {
        int[] pi = makePi(pattern); // 실패 함수 (partial match table) 생성
        int j = 0; // pattern 인덱스

        for (int i = 0; i < text.length; i++) {
            // 불일치 시, 접두사-접미사 정보를 활용해 건너뜀
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }

            // 현재 문자 일치
            if (text[i] == pattern[j]) {
                j++;
                // 패턴 전체가 매칭되었을 때
                if (j == pattern.length) return true;
            }
        }

        return false;
    }

    /**
     * KMP 실패 함수 (pi 배열) 생성
     * pi[i]는 i번째 문자까지의 접두사 == 접미사 길이를 의미
     */
    static int[] makePi(int[] pattern) {
        int[] pi = new int[pattern.length];
        int j = 0;

        for (int i = 1; i < pattern.length; i++) {
            // 일치하지 않을 경우, 이전 단계로 점프
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            // 일치할 경우, j 증가시키고 저장
            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
