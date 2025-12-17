import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int sum = 0;
        Stack<Integer> numbers = new Stack<>();

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());

            if(i == 0){
                numbers.push(num);
                sum += num;
                continue;
            }

            if(num == 0){
                sum -= numbers.pop();
            } else {
                sum += num;
                numbers.push(num);
            }
        }

        System.out.println(sum);
    }
}
