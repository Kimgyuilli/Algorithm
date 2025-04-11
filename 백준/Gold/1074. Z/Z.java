import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        findIndex(size, r, c);
        System.out.println(count);
    }
    public static void findIndex(int size, int row, int col){
        if(size == 1) return;

        if(row < size/2 && col < size / 2){  // 1
            findIndex(size/2, row, col);

        } else if(row < size/2 && col >= size / 2){ // 2
            count += size * size / 4;
            findIndex(size/2, row, col - size/2);

        } else if(row >= size/2 && col < size / 2){ // 3
            count += (size * size / 4) * 2;
            findIndex(size/2, row - size / 2, col);

        } else{ // 4
            count += (size * size / 4) * 3;
            findIndex(size/2, row - size/2, col - size/2);
        }



    }
}
