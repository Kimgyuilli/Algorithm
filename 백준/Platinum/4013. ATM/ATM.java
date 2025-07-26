import java.util.*;
import java.io.*;
import java.util.stream.*;
 
public class Main {
    static boolean[] finished,isRes;
    static int n, m, index, sccIndex, start, max;
    static int[] discover,sccNum,atm,totalAtm,dp;
    static ArrayList<ArrayList<Integer>> list,sccList;
    static Stack<Integer> st;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new ArrayList<>();
        atm = new int[n+1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
 
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            list.get(edge[0]).add(edge[1]);
        }
        for(int i=1;i<=n;i++) atm[i] = Integer.parseInt(br.readLine());
 
        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        isRes = new boolean[n+1];
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(e->isRes[e]=true);
 
        findScc();
        setSccInfo();
        sccBfs();
 
        for(int i=1;i<=n;i++)
            if(isRes[i]) max = Math.max(max,dp[sccNum[i]]);
        System.out.println(max);
 
    }
 
    private static void sccBfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(sccNum[start]);
        dp[sccNum[start]] = totalAtm[sccNum[start]];
 
        while (!q.isEmpty()){
            Integer cur = q.poll();
 
            for (Integer next : sccList.get(cur)) {
                if(dp[next] < dp[cur] + totalAtm[next]){
                    dp[next] = dp[cur]+totalAtm[next];
                    q.add(next);
                }
            }
        }
    }
 
 
    private static void setSccInfo() {
        totalAtm = new int[sccIndex+1];
        sccList = new ArrayList<>();
        dp = new int[sccIndex+1];
        for(int i=0;i<=sccIndex;i++) sccList.add(new ArrayList<>());
 
        for (int i = 1; i <= n; i++) {
            totalAtm[sccNum[i]]+=atm[i];
            for (Integer next : list.get(i))
                if (sccNum[i] != sccNum[next]) sccList.get(sccNum[i]).add(sccNum[next]);
        }
    }
 
    private static void findScc() {
 
        index = 0;
        discover = new int[n + 1];
        finished = new boolean[n + 1];
        st = new Stack<>();
        sccIndex = 0;
        sccNum = new int[n + 1];
 
        for (int i = 1; i <= n; i++)
            if (discover[i] == 0) dfs(i);
 
    }
 
    private static int dfs(int cur) {
        discover[cur] = ++index;
        st.push(cur);
 
        int parent = discover[cur];
        for (Integer next : list.get(cur)) {
            if (discover[next] == 0) parent = Math.min(dfs(next), parent);
            else if (!finished[next]) parent = Math.min(discover[next], parent);
        }
 
        if (parent == discover[cur]) {
            while (true) {
                Integer pop = st.pop();
                finished[pop] = true;
                sccNum[pop] = sccIndex + 1;
                if (pop == cur) break;
            }
            sccIndex++;
        }
        return parent;
    }
}