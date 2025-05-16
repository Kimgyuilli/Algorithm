import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int Xcount, Ocount;
    static char[][] map = new char[3][3];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            Xcount = 0;
            Ocount = 0;
            for(int i = 0; i < 3 ; i++) {
                for(int j = 0; j < 3; j++) {
                    map[i][j] = input.charAt(i * 3 + j);
                    if(map[i][j] == 'X') {
                        Xcount++;
                    } else if (map[i][j] == 'O') {
                        Ocount++;
                    } else if(map[i][j] == '.') {
                        map[i][j] = '.';
                    } else {
                        return;
                    }
                }
            }
            boolean Xwin = isWin('X');
            boolean Owin = isWin('O');

            if(Xcount < Ocount){
                System.out.println("invalid");
                continue;
            }
            if(Xwin && Owin) {
                System.out.println("invalid");
                continue;
            } else if (!Xwin && !Owin && Xcount + Ocount < 9) {
                System.out.println("invalid");
                continue;
            }
            if(Xwin && Xcount != Ocount + 1) {
                System.out.println("invalid");
                continue;
            }
            if(Owin && Xcount != Ocount) {
                System.out.println("invalid");
                continue;
            }
            System.out.println("valid");

        }
    }

    static boolean isWin(char player) {
        for(int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) {
                return true;
            }
        }
        for(int i = 0; i < 3; i++) {
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) {
                return true;
            }
        }
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) {
            return true;
        }
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) {
            return true;
        }
        return false;

    }

}
