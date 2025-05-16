import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int Xcount, Ocount;
    static char[][] map = new char[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;
            if (input.length() != 9) {
                System.out.println("invalid");
                continue;
            }

            Xcount = 0;
            Ocount = 0;

            // 보드 구성 및 개수 세기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = input.charAt(i * 3 + j);
                    if (c == 'X') Xcount++;
                    else if (c == 'O') Ocount++;
                    else if (c != '.') {
                        System.out.println("invalid");
                        continue;
                    }
                    map[i][j] = c;
                }
            }

            boolean Xwin = isWin('X');
            boolean Owin = isWin('O');

            // 불가능한 수 차이
            if (Xcount < Ocount || Xcount > Ocount + 1) {
                System.out.println("invalid");
                continue;
            }

            // 둘 다 승리하면 안 됨
            if (Xwin && Owin) {
                System.out.println("invalid");
                continue;
            }

            // 승리 조건에 맞지 않는 수 차이
            if (Xwin && Xcount != Ocount + 1) {
                System.out.println("invalid");
                continue;
            }

            if (Owin && Xcount != Ocount) {
                System.out.println("invalid");
                continue;
            }

            // 아무도 안 이기고 판도 안 찼으면 진행 중인 게임 (invalid)
            if (!Xwin && !Owin && Xcount + Ocount < 9) {
                System.out.println("invalid");
                continue;
            }

            // 유효한 종료 상태
            System.out.println("valid");
        }
    }

    static boolean isWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) return true;
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) return true;
        }
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;
        return false;
    }
}
