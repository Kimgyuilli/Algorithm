/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode target;
    private TreeNode find;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        dfs(cloned);

        return find;
    }

    private void dfs(TreeNode node) {
        if(node == null || find != null) return;

        if(node.val == target.val) {
            find = node;
            return;
        }

        dfs(node.left);
        dfs(node.right);
        
        return;
    }
}