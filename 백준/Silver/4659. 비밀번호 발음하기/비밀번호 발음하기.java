import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if(s.equals("end")) return; // 0. end가 입력되면 종료

            boolean moumContains = false;
            boolean acceptable = true;
            char prev = ' ';
            int moCount = 0;
            int jaCount = 0;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 1. 모음이 포함돼있는지 검사
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    if(!moumContains) moumContains = true;
                    moCount++;
                    jaCount = 0;
                } else {
                    jaCount++;
                    moCount = 0;
                }

                // 2. 연속 3개 검사
                if(moCount >= 3 || jaCount >= 3) {
                    acceptable = false;
                    break;
                }

                // 3. 같은 글자 검사
                if(prev == c && c != 'e' && c != 'o') {
                    acceptable = false;
                    break;
                }

                prev = c;
            }
            if(moumContains && acceptable) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
}