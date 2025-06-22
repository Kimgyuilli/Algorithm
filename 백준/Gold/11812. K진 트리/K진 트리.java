import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {

    static Long N, K, Q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        for( int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long count = 0;
            if(K == 1){
                count = abs(a - b);
            } else {

                while (a != b)
                {
                    if (a > b)
                    {
                        a = (a == 1 ? 1 : (a - 2) / K + 1);
                    }
                    else
                    {
                        b = (b == 1 ? 1 : (b - 2) / K + 1);
                    }

                    count++;
                }

            }

            System.out.println(count);

        }

    }

}
