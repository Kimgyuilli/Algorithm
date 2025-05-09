import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];

        if(N==K){
            System.out.println(0);
        } else {
        bfs(N);
        }
    }
    private static void bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        arr[N] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<3; i++){
                int next;
                if(i==0){
                    next=cur + 1;
                }
                else if(i==1){
                    next=cur-1;
                }
                else{
                    next=cur*2;
                }
                if(next==K){
                    System.out.println(arr[cur]);
                    return;
                }
                if(next>0 && next < arr.length && arr[next]==0){
                    q.add(next);
                    arr[next] = arr[cur] + 1;
                }
            }
        }
     }
}
