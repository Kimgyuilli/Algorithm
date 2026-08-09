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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
           return null;
        }  
        int max = 0;
        int idx = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(nums[idx]);

        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx + 1, len));

        return root;
    }
}