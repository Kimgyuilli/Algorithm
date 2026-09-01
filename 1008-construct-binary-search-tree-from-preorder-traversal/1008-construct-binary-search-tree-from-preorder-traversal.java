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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node = new TreeNode(preorder[0]);
        
        for(int i = 1; i < preorder.length; i++) {
            BST(preorder[i], node);
        }
        
        return node;
    }

    private void BST(int target, TreeNode node) {
        if(target < node.val) {
            if(node.left == null) {
                node.left = new TreeNode(target);
            } else {
                BST(target, node.left);
            }
        } else if(target > node.val) {
            if(node.right == null) {
                node.right = new TreeNode(target);
            } else {
                BST(target, node.right);
            }
        }
    }
}