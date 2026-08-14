class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root.left, false, root.val % 2 == 0) + dfs(root.right, false, root.val % 2 == 0);
    }
    public int dfs(TreeNode node,boolean gp, boolean p) {
        if(node == null) return 0;
        
        int s=0;

        if(gp) s+=node.val;

        return dfs(node.left, p, node.val % 2 == 0) + dfs(node.right, p, node.val % 2 == 0) + s;
    }
}