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

    private final List<TreeNode> sorted = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {

        inorder(root);
        return build(0, sorted.size() - 1);
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        sorted.add(root);
        inorder(root.right);

        return;
    }

    private TreeNode build(int start, int end) {
        if(start > end) return null;

        int mid = start + (end-start) / 2;

        TreeNode root = sorted.get(mid);
        root.left  = build(start, mid - 1);
        root.right = build(mid + 1, end);

        return root;
    }
}