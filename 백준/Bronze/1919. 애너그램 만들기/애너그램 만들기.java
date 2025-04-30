import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int sum = 0;

        String arr1 = br.readLine();
        String arr2 = br.readLine();

        char alp1[] = new char[26];
        char alp2[] = new char[26];

        for (int i = 0; i < arr1.length(); i++) {
            alp1[arr1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr2.length(); i++) {
            alp2[arr2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alp1[i] != alp2[i]) {
                sum += Math.abs(alp1[i] - alp2[i]);
            }
        }

        System.out.println(sum);
    }
}
