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
    public TreeNode reverseOddLevels(TreeNode root) {
        switchNodes(root.left, root.right, 1);
        return root;
    }

    private void switchNodes(TreeNode left, TreeNode right, int depth)  {
        
        if (left == null || right == null) return;

        if (depth % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        switchNodes(left.left, right.right, depth + 1);
        switchNodes(left.right, right.left, depth + 1);
    }
}