import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 static int N;
 static int[] board;
 static int count = 0;
 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     N = Integer.parseInt(br.readLine());
     board = new int[N];

     dfs(0);
     System.out.println(count);
 }

 public static void dfs(int depth) {
     if(depth == N) {
         count++;
         return;
     }
     for(int i = 0; i < N; i++) {
         board[depth] = i;
         if(possible(depth)) {
             dfs(depth + 1);
         }
     }
 }

 public static boolean possible(int depth) {
     for(int i = 0; i < depth; i++) {
         if(board[i] == board[depth]) return false;
         else if(Math.abs(depth-i) == Math.abs(board[depth]-board[i])) return false;
     }
     return true;
 }
}