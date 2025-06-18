import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 1; // 시작 페이지
        int end = Integer.parseInt(br.readLine()); // 끝 페이지 (입력값 N)
        int[] digitCount = new int[10]; // 0~9까지 등장 횟수
        int placeValue = 1; // 자리수 (1의 자리 → 10의 자리 → 100의 자리 ...)

        while (start <= end) {

            // 1) end 페이지의 끝자리를 9로 맞추기 (부분 처리)
            while (end % 10 != 9 && start <= end) {
                countDigits(end, digitCount, placeValue);
                end--;
            }

            // 2) 시작 > 끝이면 종료
            if (start > end) break;

            // 3) start 페이지의 끝자리를 0으로 맞추기 (부분 처리)
            while (start % 10 != 0 && start <= end) {
                countDigits(start, digitCount, placeValue);
                start++;
            }

            // 4) 이제 start 는 0으로 끝나고, end 는 9로 끝나는 상태
            //    해당 구간은 패턴 반복 → 한 번에 계산
            int pageRange = (end / 10 - start / 10 + 1);
            for (int digit = 0; digit < 10; digit++) {
                digitCount[digit] += pageRange * placeValue;
            }

            // 자리수 상승
            placeValue *= 10;
            start /= 10;
            end /= 10;
        }

        // 결과 출력
        Arrays.stream(digitCount)
                .forEach(count -> System.out.print(count + " "));
    }

    // 주어진 숫자 n 을 각 자리별로 쪼개서 count 에 반영
    public static void countDigits(int number, int[] digitCount, int placeValue) {
        while (number > 0) {
            digitCount[number % 10] += placeValue;
            number /= 10;
        }
    }
}
