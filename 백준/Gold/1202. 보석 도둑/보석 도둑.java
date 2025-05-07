import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Gem {
        int weight;
        int value;

        Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[n];
        int[] bags = new int[k];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            gems[i] = new Gem(weight, value);
        }
        
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(gems, Comparator.comparingInt(g -> g.weight));
        Arrays.sort(bags);

        long totalValue = 0;
        int gemIndex = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            int capacity = bags[i];
            
            while (gemIndex < n && gems[gemIndex].weight <= capacity) {
                pq.offer(gems[gemIndex].value);
                gemIndex++;
            }
            
            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }

        System.out.println(totalValue);
    }
}
