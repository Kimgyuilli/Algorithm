import java.io.*;
import java.util.*;

public class Main {

    static String text, pattern;          // 전체 문자열과 찾고자 하는 패턴
    static int[] pi;                      // 접두사와 접미사의 일치 길이를 저장하는 pi 배열
    static List<Integer> result = new ArrayList<>();  // 패턴이 등장한 위치들 (1-based index)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        text = br.readLine();    // 전체 텍스트 입력
        pattern = br.readLine(); // 검색할 패턴 입력

        getPi();  // 패턴의 접두사/접미사 일치 테이블 생성
        kmp();    // 텍스트에서 패턴 검색

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n"); // 등장 횟수 출력
        for (int pos : result) {
            sb.append(pos).append(" ");        // 각 위치 출력 (1부터 시작)
        }
        System.out.println(sb);
    }

    // 패턴에서 pi 배열을 구하는 함수 (KMP 사전 처리)
    static void getPi() {
        int m = pattern.length();
        pi = new int[m];   // 길이 m의 pi 배열 생성

        int j = 0;         // 일치한 접두사 길이
        for (int i = 1; i < m; i++) {
            // j가 0이 아니고, 현재 문자가 일치하지 않을 때 이전 pi로 돌아감
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            // 문자가 일치하면 pi[i]는 j+1
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    // 텍스트에서 패턴을 검색하는 함수
    static void kmp() {
        int n = text.length();
        int m = pattern.length();
        int j = 0;  // 현재 패턴 매칭 길이

        for (int i = 0; i < n; i++) {
            // 현재 문자 불일치 시 이전 일치 정보를 참고하여 j 이동
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            // 문자 일치 시
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    // 패턴의 마지막 문자까지 일치 → 전체 패턴 매칭 성공
                    result.add(i - m + 2); // 1-based index로 저장
                    j = pi[j];             // 다음 가능한 일치 위치로 이동
                } else {
                    j++; // 다음 패턴 문자로 진행
                }
            }
        }
    }
}
