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
    private int sum;

    public int sumEvenGrandparent(TreeNode root) {

        findEvenSonSon(root.left, false, root.val % 2 == 0);    
        findEvenSonSon(root.right, false, root.val % 2 == 0);

        return sum;
    }

    private void findEvenSonSon(TreeNode node, boolean gp, boolean p) {
        if(node == null) return;
        if(gp) sum += node.val;

        findEvenSonSon(node.left, p, node.val % 2 == 0);    
        findEvenSonSon(node.right, p, node.val % 2 == 0);

    }

}