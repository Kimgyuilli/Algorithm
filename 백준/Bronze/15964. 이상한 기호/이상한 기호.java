
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());

        System.out.println((n1 + n2) * (n1 - n2));
    }
}
