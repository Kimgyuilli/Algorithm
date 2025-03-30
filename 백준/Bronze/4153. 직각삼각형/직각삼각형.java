import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            list = new int[3];
            list[0] = Integer.parseInt(st.nextToken());
            list[1] = Integer.parseInt(st.nextToken());
            list[2] = Integer.parseInt(st.nextToken());

            sort(list);

            if(list[0] == 0 && list[1] == 0 && list[2] == 0){
                return;
            }

            if(Math.pow(list[0], 2) + Math.pow(list[1], 2) == Math.pow(list[2], 2)){
                System.out.println("right");
            } else{
                System.out.println("wrong");
            }

        }

    }
}