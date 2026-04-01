import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();
        
        Set<String> players = new HashSet<>();
        for (int i = 0; i < n; i++) {
            players.add(br.readLine());
        }

        int uniquePlayers = players.size();
        int maxGames = 0;
        
        if (gameType.equals("Y")) {
            maxGames = uniquePlayers;
        } else if (gameType.equals("F")) {
            maxGames = uniquePlayers / 2;
        } else if (gameType.equals("O")) {
            maxGames = uniquePlayers / 3;
        }

        System.out.println(maxGames);
    }
}