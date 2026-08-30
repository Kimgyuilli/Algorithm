/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private String traversal;
    private int len;
    private int idx = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        this.traversal = traversal;
        this.len = traversal.length();

        return DFS(0);
    }

    private TreeNode DFS(int depth) {
        int tempIdx = idx;
        int count = 0;

        while(tempIdx < len && traversal.charAt(tempIdx) == '-') {
            tempIdx++;
            count++;
        }

        if(count != depth) {
            return null;
        }

        int num = 0;

        while(tempIdx < len && traversal.charAt(tempIdx) != '-') {
            num *= 10;
            num += traversal.charAt(tempIdx) - '0';
            tempIdx++;
        }

        this.idx = tempIdx;

        TreeNode node = new TreeNode(num);
        node.left = DFS(depth + 1);
        node.right = DFS(depth + 1);
        return node;

    }
}