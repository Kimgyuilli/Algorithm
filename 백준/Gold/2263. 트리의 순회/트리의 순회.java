import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] in_order, post_order;
    static Map<Integer, Integer> inOrderIndex;  // in_order 값 → index 맵핑 (빠른 탐색용)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());  // 노드 개수 입력
        in_order = new int[N];
        post_order = new int[N];
        inOrderIndex = new HashMap<>();

        // in_order 입력 받기 + index 맵에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            in_order[i] = Integer.parseInt(st.nextToken());
            inOrderIndex.put(in_order[i], i);  // 값 → index 저장
        }

        // post_order 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            post_order[i] = Integer.parseInt(st.nextToken());
        }

        // 전체 트리를 재귀적으로 preorder 출력
        buildPreOrder(0, N - 1, 0, N - 1);
    }

    /**
     * 현재 서브트리 범위를 in_order, post_order 구간으로 주고 preorder 출력하는 함수
     *
     * @param inStart    현재 in_order 범위 시작 index
     * @param inEnd      현재 in_order 범위 끝 index
     * @param postStart  현재 post_order 범위 시작 index
     * @param postEnd    현재 post_order 범위 끝 index
     */
    static void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        // 기저 조건: 더 이상 탐색할 구간이 없으면 return
        if (inStart > inEnd || postStart > postEnd) return;

        // 현재 서브트리의 루트는 post_order 맨 마지막 값
        int root = post_order[postEnd];

        // preorder 이므로 루트를 먼저 출력
        System.out.print(root + " ");

        // 루트 값이 in_order 배열에서 어디에 있는지 찾음 (왼쪽/오른쪽 서브트리 구간 나누기 위해)
        int rootIndex = inOrderIndex.get(root);

        // 왼쪽 서브트리 노드 개수 계산
        int leftSize = rootIndex - inStart;

        // --- 왼쪽 서브트리 탐색 ---
        // in_order: 왼쪽 서브트리 범위 [inStart ~ rootIndex -1]
        // post_order: 왼쪽 서브트리 범위 [postStart ~ postStart + leftSize -1]
        buildPreOrder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);

        // --- 오른쪽 서브트리 탐색 ---
        // in_order: 오른쪽 서브트리 범위 [rootIndex +1 ~ inEnd]
        // post_order: 오른쪽 서브트리 범위 [postStart + leftSize ~ postEnd -1]
        buildPreOrder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }

}
