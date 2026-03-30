import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if(s.equals(".")) return;
            Deque<Character> dq = new ArrayDeque<>();
            boolean isRight = true;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == '(' || c == '[') {
                    dq.push(c);
                    continue;
                }

                if(c == ')') {
                    if(dq.isEmpty() || dq.peek() != '(') {
                        isRight = false;
                        break;
                    }
                    dq.pop();
                } else if(c == ']') {
                    if (dq.isEmpty() || dq.peek() != '[') {
                        isRight = false;
                        break;
                    }
                    dq.pop();
                }
            }
            System.out.println(isRight && dq.isEmpty() ? "yes" : "no");
        }
    }
}