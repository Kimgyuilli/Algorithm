import java.util.*;

class Solution {

    private final int[][] ADJ = {
        {1, 3},
        {0, 2, 4},
        {1, 5},
        {0, 4},
        {1, 3, 5},
        {2, 4}
    };

    private class State {
        String board;
        int depth;

        State(String board, int depth) {
            this.board = board;
            this.depth = depth;
        }
    }

    public int slidingPuzzle(int[][] board) {
        String start = "" + board[0][0] + board[0][1] + board[0][2]
                  + board[1][0] + board[1][1] + board[1][2];

        Set<String> visited = new HashSet<>();
        visited.add(start);

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(start, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.board.equals("123450")) {
                return cur.depth;
            }

            int zero = cur.board.indexOf('0');

            for (int next : ADJ[zero]) {
                char[] arr = cur.board.toCharArray();

                arr[zero] = arr[next];
                arr[next] = '0';

                String nextBoard = new String(arr);

                if (visited.contains(nextBoard)) continue;

                visited.add(nextBoard);
                q.offer(new State(nextBoard, cur.depth + 1));
            }
        }

        return -1;
    }
}