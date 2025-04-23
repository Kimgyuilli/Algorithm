import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int[][] board = new int[9][9];               // 스도쿠 판
    static boolean[][] rowCheck = new boolean[9][10];   // 각 행에 숫자 사용 여부
    static boolean[][] colCheck = new boolean[9][10];   // 각 열에 숫자 사용 여부
    static boolean[][] boxCheck = new boolean[9][10];   // 각 3x3 박스에 숫자 사용 여부
    static int recursionCount = 0;

    // 현재 좌표가 속한 3x3 박스 번호 계산
    static int getBoxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    // 백트래킹으로 스도쿠 풀기
    static boolean solve(int cellIndex) {
        recursionCount++;
        if (recursionCount >= 10000000) return true;

        if (cellIndex == 81) {
            printBoard();
            return true;
        }

        int row = cellIndex / 9;
        int col = cellIndex % 9;

        if (board[row][col] != 0) {
            return solve(cellIndex + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                int box = getBoxIndex(row, col);
                if (!rowCheck[row][num] && !colCheck[col][num] && !boxCheck[box][num]) {
                    // 숫자 배치
                    rowCheck[row][num] = colCheck[col][num] = boxCheck[box][num] = true;
                    board[row][col] = num;

                    if (solve(cellIndex + 1)) return true;

                    // 백트래킹
                    board[row][col] = 0;
                    rowCheck[row][num] = colCheck[col][num] = boxCheck[box][num] = false;
                }
            }
        }
        return false;
    }

    // 스도쿠 판 출력
    static void printBoard() {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value);  // 공백 제거
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        // 입력 처리 및 초기 사용 숫자 체크
        for (int row = 0; row < 9; row++) {
            String line = br.readLine();
            for (int col = 0; col < 9; col++) {
                board[row][col] = line.charAt(col)-'0';
                int value = board[row][col];
                if (value != 0) {
                    rowCheck[row][value] = true;
                    colCheck[col][value] = true;
                    boxCheck[getBoxIndex(row, col)][value] = true;
                }
            }
        }

        // 스도쿠 풀기 시작
        solve(0);
    }
}
