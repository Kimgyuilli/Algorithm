import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            // current보다 작은 노드는 current의 왼쪽 서브트리가 된다.
            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            // 스택에 남은 가장 가까운 큰 노드의 오른쪽 자식이 된다.
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            stack.push(current);
        }

        // 스택 맨 아래에 전체 트리의 루트가 있다.
        return stack.peekLast();
    }
}