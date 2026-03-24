import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int colLen = relation[0].length;
        List<List<Integer>> candidateKeys = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        for (int i = 0; i < colLen; i++) {
            queue.offer(new ArrayList<>(List.of(i)));
        }

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();

            // 최소성 체크
            boolean skip = false;
            for (List<Integer> key : candidateKeys) {
                if (cur.containsAll(key)) { skip = true; break; }
            }
            if (skip) continue;

            // 유일성 체크
            if (isUnique(cur, relation)) {
                candidateKeys.add(cur);
            } else {
                int lastCol = cur.get(cur.size() - 1);
                for (int i = lastCol + 1; i < colLen; i++) {
                    List<Integer> next = new ArrayList<>(cur);
                    next.add(i);
                    queue.offer(next);
                }
            }
        }

        return candidateKeys.size();
    }

    private boolean isUnique(List<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int c : cols) sb.append(row[c]).append("/");
            if (!seen.add(sb.toString())) return false;
        }
        return true;
    }
}