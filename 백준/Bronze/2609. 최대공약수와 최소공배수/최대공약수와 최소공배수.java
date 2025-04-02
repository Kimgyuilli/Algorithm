import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());


        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int max = 0; //최대 공약수

        for(int i=1; i<=num1 && i<=num2; i++)
        {
            if(num1%i==0 && num2%i==0)
            {
                max = i;
            }
        }

        int min = (num1*num2)/max; //최소 공배수

        System.out.println(max);
        System.out.println(min);
    }
}
