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
    int max = 0;
    int answer = 0;
    public int deepestLeavesSum(TreeNode root) {
        DFS(root, 0);
        return answer;
    }

    private void DFS(TreeNode root, int depth) {
        if(root == null) return;

        if(depth > max) {
            max = depth;
            answer = root.val;
        } else if(depth == max) {
            answer += root.val;
        }
        

        DFS(root.left, depth + 1);
        DFS(root.right, depth + 1);
    }
}